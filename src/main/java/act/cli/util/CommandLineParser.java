package act.cli.util;

import act.cli.InvalidCommandLineException;
import org.osgl.util.C;
import org.osgl.util.E;
import org.osgl.util.S;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parse a command line
 */
public class CommandLineParser {
    private String command;
    private String raw;
    /*
     * Map value part to lead part. E.g.
      * {@code -n 10} create an entry ("-n", "10") and
      * {@code -b} create an entry ("-b", "true")
     */
    private Map<String, String> options;
    private List<String> arguments;

    static final Pattern P = Pattern.compile("([^\"]\\S*|\".+?\")\\s*");
    public CommandLineParser(String line) {
        E.illegalArgumentIf(S.blank(line));
        raw = line.trim();
        options = C.newMap();
        List<String> sl = C.newList();
        Matcher m = P.matcher(raw);
        while (m.find()) {
            String s = m.group(1);
            s = S.strip(s, "\"", "\"");
            sl.add(s);
        }
        parse(sl);
    }

    private void parse(List<String> tokens) {
        command = tokens.remove(0).intern();
        String lead = null;
        for (String cur : tokens) {
            if (cur.startsWith("-")) {
                // todo handle --option=a, --option:b style
                String[] sa = cur.split("[=:]");
                switch (sa.length) {
                    case 1:
                        break;
                    case 2:
                        options.put(sa[0], sa[1]);
                        continue;
                    default:
                        throw new InvalidCommandLineException("uknown option: %s", cur);
                }
                if (null != lead) {
                    options.put(lead, "true");
                }
                lead = cur;
            } else {
                if (null != lead) {
                    options.put(lead, cur);
                    lead = null;
                } else {
                    if (null == arguments) {
                        arguments = C.newList();
                    }
                    arguments.add(cur);
                }
            }
        }
    }

    public String command() {
        return command;
    }

    public List<String> arguments() {
        return C.list(arguments);
    }

    public boolean getBoolean(String lead1, String lead2) {
        String s = o(lead1, lead2);
        return "true" == s;
    }

    public Boolean getBooleanObject(String lead1, String lead2) {
        return getBoolean(lead1, lead2);
    }

    public byte getByte(String lead1, String lead2, Byte def) {
        Byte b = getByteObject(lead1, lead2, def);
        if (null != b) {
            return b;
        }
        throw new InvalidCommandLineException("Cannot get byte type option");
    }

    public Byte getByteObject(String lead1, String lead2, Byte def) {
        String s = o(lead1, lead2);
        return null == s ? def : Byte.valueOf(s);
    }

    public char getChar(String lead1, String lead2, Character def) {
        Character c = getCharObject(lead1, lead2, def);
        if (null != c) {
            return c;
        }
        throw new InvalidCommandLineException("Cannot get char type option");
    }

    public Character getCharObject(String lead1, String lead2, Character def) {
        String s = o(lead1, lead2);
        return null == s ? def : s.charAt(0);
    }

    public short getShort(String lead1, String lead2, Short def) {
        Short o = getShortObject(lead1, lead2, def);
        if (null != o) {
            return o;
        }
        throw new InvalidCommandLineException("Cannot get short type option");
    }

    public Short getShortObject(String lead1, String lead2, Short def) {
        String s = o(lead1, lead2);
        return null == s ? def : Short.valueOf(s);
    }

    public int getInt(String lead1, String lead2, Integer def) {
        Integer n = getIntObject(lead1, lead2, def);
        if (null != n) {
            return n;
        }
        throw new InvalidCommandLineException("Cannot get int type option");
    }

    public Integer getIntObject(String lead1, String lead2, Integer def) {
        String s = o(lead1, lead2);
        return null == s ? def : Integer.valueOf(s);
    }

    public float getFloat(String lead1, String lead2, Float def) {
        Float o = getFloatObject(lead1, lead2, def);
        if (null != o) {
            return o;
        }
        throw new InvalidCommandLineException("Cannot get float type option");
    }

    public Float getFloatObject(String lead1, String lead2, Float def) {
        String s = o(lead1, lead2);
        return null == s ? def : Float.valueOf(s);
    }

    public long getLong(String lead1, String lead2, Long def) {
        Long o = getLongObject(lead1, lead2, def);
        if (null != o) {
            return o;
        }
        throw new InvalidCommandLineException("Cannot get long type option");
    }

    public Double getDoubleObject(String lead1, String lead2, Double def) {
        String s = o(lead1, lead2);
        return null == s ? def : Double.valueOf(s);
    }

    public double getDouble(String lead1, String lead2, Double def) {
        Double o = getDoubleObject(lead1, lead2, def);
        if (null != o) {
            return o;
        }
        throw new InvalidCommandLineException("Cannot get double type option");
    }

    public Long getLongObject(String lead1, String lead2, Long def) {
        String s = o(lead1, lead2);
        return null == s ? def : Long.valueOf(s);
    }

    public String getString(String lead1, String lead2) {
        return o(lead1, lead2);
    }

    private String o(String lead1, String lead2) {
        String s = options.get(lead1);
        return null == s ? options.get(lead2) : s;
    }

}
