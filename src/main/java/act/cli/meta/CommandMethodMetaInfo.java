package act.cli.meta;

import act.Act;
import act.Destroyable;
import act.app.AppClassLoader;
import act.asm.Type;
import act.cli.view.CliView;
import act.handler.CliHandler;
import act.sys.meta.InvokeType;
import act.sys.meta.ReturnTypeInfo;
import act.util.DestroyableBase;
import act.util.PropertySpec;
import org.osgl.$;
import org.osgl.util.C;
import org.osgl.util.E;
import org.osgl.util.S;

import java.util.List;
import java.util.Set;

/**
 * Stores the command method meta info including
 * <ul>
 *     <li>method name</li>
 *     <li>method invocation type</li>
 *     <li>return type</li>
 *     <li>param info and associated annotation info</li>
 * </ul>
 */
public class CommandMethodMetaInfo extends DestroyableBase {

    private String methodName;
    private String commandName;
    private String helpMsg;
    private InvokeType invokeType;
    private CommanderClassMetaInfo clsInfo;
    private PropertySpec.MetaInfo propertySpec;
    private C.List<CommandParamMetaInfo> params = C.newList();
    private ReturnTypeInfo returnType;
    private Set<String> optionLeads = C.newSet();
    private CliView view = CliView.TO_STRING;
    private Act.Mode mode = Act.Mode.PROD;

    public CommandMethodMetaInfo(CommanderClassMetaInfo clsInfo) {
        this.clsInfo = $.NPE(clsInfo);
    }

    public CommanderClassMetaInfo classInfo() {
        return clsInfo;
    }

    public CommandMethodMetaInfo methodName(String name) {
        this.methodName = $.NPE(name);
        return this;
    }

    public String methodName() {
        return methodName;
    }

    public CommandMethodMetaInfo view(CliView view) {
        this.view = $.notNull(view);
        return this;
    }

    public CliView view() {
        return view;
    }

    public CommandMethodMetaInfo commandName(String name) {
        commandName = $.NPE(name);
        return this;
    }

    public String commandName() {
        return commandName;
    }

    public String fullName() {
        return S.builder(clsInfo.className()).append(".").append(methodName()).toString();
    }

    public CommandMethodMetaInfo helpMsg(String msg) {
        helpMsg = msg;
        return this;
    }

    public String helpMsg() {
        return null == helpMsg ? "" : helpMsg;
    }

    /**
     * Returns {@link CliHandler#options()}
     * @return options list
     * @see CliHandler#options()
     */
    public List<$.T2<String, String>> options(CommanderClassMetaInfo classMetaInfo, AppClassLoader classLoader) {
        List<$.T2<String, String>> retVal = C.newList();
        for (CommandParamMetaInfo param : params) {
            OptionAnnoInfoBase opt = param.optionInfo();
            if (null != opt) {
                retVal.add($.T2(opt.leads(), opt.help()));
            }
        }
        for (OptionAnnoInfoBase opt : classMetaInfo.fieldOptionAnnoInfoList(classLoader)) {
            retVal.add($.T2(opt.leads(), opt.help()));
        }
        return retVal;
    }

    /**
     * Returns {@link act.handler.CliHandler#commandLine(String)}
     * @return the command line
     * @see act.handler.CliHandler#commandLine(String)
     */
    public $.T2<String, String> commandLine(String commandName, CommanderClassMetaInfo classMetaInfo, AppClassLoader classLoader) {
        boolean hasOptions = classMetaInfo.hasOption(classLoader);
        String firstArg = null;
        boolean hasMoreArgs = false;
        for (CommandParamMetaInfo param : params) {
            if (param.optionInfo() != null) {
                hasOptions = true;
            } else {
                if (firstArg == null) {
                    firstArg = param.name();
                } else {
                    hasMoreArgs = true;
                }
            }
        }
        StringBuilder sb = S.builder(commandName);
        if (hasOptions) {
            sb.append(" [options]");
        }
        if (null != firstArg) {
            sb.append(" ");
            sb.append("[").append(firstArg);
            if (hasMoreArgs) {
                sb.append("...");
            }
            sb.append("]");
        }
        return $.T2(sb.toString(), helpMsg());
    }

    public CommandMethodMetaInfo mode(Act.Mode mode) {
        this.mode = mode;
        return this;
    }

    public Act.Mode mode() {
        return mode;
    }

    public CommandMethodMetaInfo invokeStaticMethod() {
        invokeType = InvokeType.STATIC;
        return this;
    }

    public CommandMethodMetaInfo invokeInstanceMethod() {
        invokeType = InvokeType.VIRTUAL;
        return this;
    }

    public boolean isStatic() {
        return InvokeType.STATIC == invokeType;
    }

    public CommandMethodMetaInfo propertySpec(PropertySpec.MetaInfo propertySpec) {
        this.propertySpec = propertySpec;
        return this;
    }

    public PropertySpec.MetaInfo propertySpec() {
        return propertySpec;
    }

    public CommandMethodMetaInfo returnType(Type type) {
        returnType = ReturnTypeInfo.of(type);
        return this;
    }

    public Type returnType() {
        return returnType.type();
    }

    public CommandMethodMetaInfo addParam(CommandParamMetaInfo paramInfo) {
        params.add(paramInfo);
        return this;
    }

    public C.List<CommandParamMetaInfo> params() {
        return C.list(params);
    }

    public CommandParamMetaInfo param(int id) {
        return params.get(id);
    }

    public int paramCount() {
        return params.size();
    }

    public CommandMethodMetaInfo addLead(String lead) {
        if (null == lead) {
            return this;
        }
        if (optionLeads.contains(lead)) {
            throw E.unexpected("Duplicate option lead %s found on %s.%s", lead, clsInfo.className(), methodName);
        }
        optionLeads.add(lead);
        return this;
    }

    @Override
    protected void releaseResources() {
        super.releaseResources();
        clsInfo.destroy();
        Destroyable.Util.destroyAll(params);
    }
}
