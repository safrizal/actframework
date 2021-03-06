# ActFramework Change Log

1.4.12
* `SequenceNumberGenerator` cause error in heterogeneouse data source environment #374
* Allow inject `Dao` interface #373

1.4.11
* catch up update to 1.3.14-LTS
* Support running CLI Job in background #267 
* `job.list` CLI command failure #355 

1.4.10
* catch up update to 1.3.13-LTS

1.4.9
* catch up update to 1.3.12-LTS

1.4.8
* catch up update to 1.3.11-LTS

1.4.7
* catch up update to 1.3.10-LTS

1.4.6
* Catch up update to 1.3.9-LTS

1.4.5
* Catch up update to 1.3.8

1.4.4
* Catch up update to 1.3.7

1.4.3
* Two `WebSocketConnectionManager` exists #250 
* HttpServerExchange cannot have both async IO resumed and dispatch() called in the same cycle #248 
* catch up to bug fixes in 1.3.6

1.4.2
* catch up to bug fixes in 1.3.5

1.4.1
* `DbServiceManager.hasDbService()` error implementation #239 

1.4.0
* Update fastjson to 1.2.33 #235 
* App start event listener not called when there is no Async DbService #234 
* Generate ASCII banner for favicon #228 
* Support colorful console output #227 
* Support customized banner text #226 
* Allow app to terminate `@InheritedStateless` #223 
* Make `Dao` implementation be stateless #221 
* Automatically register a class with `@Stateless` tag into app's singleton registry #220 
* Support Lazy initialized singleton #219 
* Support initialize DbService asynchronously #217 
* Support easy configuring of header session mapper #212 
* Smart initialize Job instance #211 
* Deprecate `@Env.Mode` for `@Env.RequireMode` #207 
* Deprecate `@Env.Profile` for `@Env.RequireProfile` #206 
* Deprecate `@Env.Group` for `@Env.RequireGroup` #205 
* Log the URL with handler error message #192 
* Review and fix the use of `ConcurrentMap` #191 
* upport WebSocket #17 S

1.3.14
* Improve maven build process #372
* Improve logging support #370
* Simplify start API/implementation #369
* Introduce osgl-bootstrap and osgl-ut #368
* It shall not try to instantiate commander class for command implemented on static method #367
* NPE when building param tree #365
* Deadlock on app start  #363
* Binder annotation on bean field doesn't work #362
* Support app defined parameter binder annotation #361
* Improve app version reading support #359
* If no file selected in an upload form, the server side will trigger a 500 server error #357 
* `ProvidesImplicitTemplateVariable` generates bad rythm template source code #354 
* The rest parameters is always `null` after `@DbBind` annotated parameter #353 
* Support API document generation #351 
* Improve `Catch` interceptor API #350 
* Get `DbService` list from `DbServiceManager` by plugin class #273 
* Fix regression issues: #287 and #297

1.3.13
* Add annotation to allow developer specify a handler method's template shall not be cached #347 
* Template not found in `prod` mode #346 

1.3.12
* Support in memory cache of uploaded file when size not exceeds threshold #345 
* Support `*` in integer value configuration #344 
* Drop download upload file support #343 
* Make upload file in memory threshold be configurable #341 
* Upload file get saved twice to filesystem #340 
* Make upload file stored in a hierarchical directory structure #339 
* It shall report 400 Bad Request if required file upload is missing #338 
* StaticResourceGetter.toString method output is confusing #337 
* Act's asset static resource URL shall follow the built-in URL convention #336 
* UploadFileStorageService shall add length attribute into SObject #335 

1.3.11
* Error message could not display correctly #330 
* ACT can't register ebean as default datasource when configuration both ebean and mongo datasource #328 

1.3.10
* com.alibaba.fastjson.JSONException: default constructor not found. class act.app.ActionContext #327 

1.3.9
* Random issue: Cannot instantiate interface org.osgl.inject.ScopeCache$SingletonScope #323 
* CLI: Print out the real exception instead of `InvocationTargetException` #322 
* CLI session exit message issue #321 
* i18n message interpolation shall follow standard message format  #320 
* It shall respond with `400` when `DbBind` cannot find the binding value in the request #319 
* Cannot implement Command handler in MorphiaDao #318 
* `@DbBind` not working with JSON format #317 
* Provide a mechanism to allow plugin listen to app hot reload event #316 
* EventBus call on `SimpleEventListener` shall throw out exceptions #313 
* when using `@Output` on field it shall allow method not to have template #312 
* Make `DbBind` annotation to support fetch all data from database #310 

1.3.8
* Add `templatePath` method into `Mailer.Util` #309 
* java.lang.IllegalStateException: parent context not found #307 
* Allow user to set content through `Mailer.Util` #306 
* Add `attach(...)` methods into `Mailer.Util` #305 
* Support early binding of `ActEventListener` #304 
* Add `classForName` method to `App` instance #303 
* `DbBind` comment error #302 
* Allow `DbBind` to use different names to map between request parameter and model field #301 
* It loads the same `routes.conf` file twice #300 
* Suppress `resource:` directive in route table #299 
* The app cannot boot up when static file routing cannot find dir #298 
* JSON binding doesn't work well with @DbBind annotation #297 
* Mail: Sending attachment caused `javax.mail.messagingexception: unknown encoding: utf-8` #294 
* English label is not correct in Act CLI #290 
* Make `@ProvidesImplicitTemplateVariable` support default value #288 
* `@ProvidesImplicitTemplateVariable`: Generic type lost #287 
* When handler has no return value it shall still check the context render arguments #286 
* `@Output` annotation on field declaration does not work #285 
* Add an annotation to support output all controller method parameters into render argument list #284 

1.3.7
* update osgl-mvc to 1.2.0 #276 
* `@AnnotatedWith` injection not work #275 
* `AdaptiveRecord.Util.asMap` method error #272 
* It shall report `405 Method Not Allowed` for HTTP method not recongized #269 
* update fastjson to 1.2.34 #265 

1.3.6
* No log for block issue encountered before loading dependency manager #261 
* Issue with `@DisableFastJsonCircularReferenceDetect` and `@GetAction` #260 
* Improve error message when template not found #258 
* SimpleBean Bytecode scanner issue: interfaces not populated in certain case #254 
* SimpleBean implementation shall be enhanced even without public fields #253 
* download stalled #252 
* StackOverflowError when the class that needs to output in CLI command contains `java.util.Locale` typed field #251 

1.3.5
* Returning Locale type result does not rendering valid JSON response #246 
* Resource consumption issue with DEV mode #244 

1.3.4
* `@Output` annotation on controller field is not effective when handler method has no parameters #202 
* Make mailer support `@TemplateContext` annotation #203 
* App bytecode enhancer state not cleaned #214 
* Improve handling of fatal error in Job method during app bootstrap #216 
* async job is not really async #222 
* double decode of URL path variable #229 
* CLI cannot input negative number #230 
* `RenderAny` shall favor `ActionContext.hasTemplate()` result  #231 
* When action handler returning an object, it failed to apply the `@ResponseStatus` annotation in certain cases #233 

1.3.3
* It does not put correct content type header when servicing static resource as css file bug fixed #200 
* Error generating error page if `Request.accept()` format is not normal #199 
* `@TemplateUrl` annotation on interceptor class shall not impact the template context of handler action #197 
* page cache key is the same for two action handler methods with the same name in different class #196 
* `MorphiaAdaptiveRecord.putValues(Map<String, Object>)` failure #193 
* Allow page cache key generator create different key by checking useragent for mobile/browser #188 
* NPE triggered on actframework official website #187 
* Add Access-Control-Allow-Credentials in CORS support #186 

1.3.2
* functional test cases break when action handler returns array of elements #194 

1.3.1
* It shall not report server error if no file uploaded #189 
* java.lang.NoClassDefFoundError: javax/persistence/Persistence #190 

1.3.0
* Create a mechanism to cache the GET request result #128 
* Introduce `@TemplateContext` annotation #163 
* Split `@Controller` annotation into `@UrlContext` and `@Port` annotation #164 
* `@Global` doesn't work when put behind the interceptor annotation #167 
* Make all scanner favor the setting of `@Env` annotations #168 
* Regex in route not working #169 
* Make it easy to create global template variable #170 
* Add helper javascript library that extends jQuery #171 
* Support profile specific route configuration #174 
* Create better error message when there are error enhancing classes #175 
* Better error reporting when multiple controller action/interceptor methods have the same name #177 
* When handler returns a primitive type the result is not JSON result when `Accept` header require JSON #178 
* Provide an annotation to mark a field or parameter as template variable #179 
* Setting character encoding in response doesn't effect correctly #180 
* Make redirect favor Controller URL context #181 
* Make app able to run `prod` mode from within IDE #182 

1.2.0
* Add an annotation that indicate an injected field is stateless #161 
* Make `ActionContext` an injectable field in `Controller.Util` #160 
* generated pid file not get deleted when app process is killed #159 
* SEO support on routing #157 
* Compile error is not displayed at dev mode #156 
* When `@NotNull` used along with `@DbBind` it shall return 404 if binding failed #153 
* Allow annotation based interceptor class to be registered as global interceptor #152 
* Allow `@With` annotation to be used on specific handler method #136 
* Improve error reporting on "Unknown accept content type" #124 

1.1.2
* Update version of osgl and other dependencies #151 
* Deadlock while app boot up #150 

1.1.1
* Support get process ID on non-unix environment #148 
* Unnecessary synchronization ReflectedHandlerInvoker.checkTemplate #147 
* When db plugin is configured, it uses empty string as service ID #146 
* `EventBus.bind(Object, SimpleEventListener)` shall check if the object type is `EventObject` #144 

1.1.0
* Always generate pid file when app start in prod mode #142 
* Support context URL path #141 
* Cannot use multiple Job annotations on one job method #140 
* allow SimpleEventHandler to be used to handle event happening before app started #139 
* Update FastJson to 1.2.31 #138 
* Provides SqlDbService as a base class for all SQL based DbService solution #135 
* upgrade FastJson to 1.2.31

1.0.7
* ake it able to configure the number of network io threads and work threads #70 M
* configuration render.json.output_charset.enabled default value shall be false #120 
* qrcode method problem #127 
* Response outputstream not closed #130 
* ZXingResult call applyAfterCommitHandler twice #131 
* "type not recognized: MODEL_TYPE" Error when using a DaoBase subclass as Controller #132 
* It uses undertow deprecated API to construct HttpOpenListener #133 
* Fine tune undertow configurations #134 

1.0.6
* caused issue that failed to add route mapping in certain case #121 #115  
* Update fastjson to 1.2.30

1.0.5
* * remove version range from pom.xml. See https://issues.apache.org/jira/browse/MNG-3092

1.0.4
* It shall display the exception stack trace tab on template exception page #109 
* Using simplified action path in @fullUrl and @url doesn't work in an free template #110 
* Routing failure on `/{path1}/{path2}/{path3}/{id}.html` style URL path #111 
* Missing embedded object content when PropertySpec is specified #112 
* Exception encountered when first field of post JSON body contains the parameter name #113 
* Router: support inner variables inside URL path #115 
* Update RythmEngine to 1.2.0
* Update joda-time to 2.9.9

1.0.3
* Error enhancing render arguments when break the statement into multiple lines #68  
* @fullUrl and @url tag doesn't work when there is no GET request mapping to the action handler method #84  
* session.ttl setting prevent app from start up #89  
* Invalid encoded characters in Error page #94  
* Act controller not return correct @version "v" for save method when MorphiaDao return the value bug #97  
* Update FastJson version to 1.2.29 #99  
* when the browser get a json request, Chinese characters are not displayed properly #100 
* IE doesn't support "application/json" content type #101 
* Incorrectly configured routes should not crash hot-reload #104 
* Reloading View manager might break the hot reload process #106 
* Simplify the use of reverse routing API #107 
* Simplify the use of `@url` and `@fullUrl` tag #108 

1.0.2
* It shall allow `null` value for enum type parameter when do the request parameter binding #86 
* DependencyInjectionListener shall register with sub classes of the target class also #87 
* Controller context break with intermediate non-controller class in the hierarchies #88 

1.0.1
* static action handler method cause NPE #79 
* Duplicate route mapping breaks the hot reloading and application state #81 #81 

1.0.0
* First formal release

0.7.0
* Validation refactory

0.6.0
* DAO API change: save(Iterable) now returns list of object been saved

0.5.0
* 0.4.0 reserved for TechEmpower benchmark set
* update dependency versions
* A lot of fix to Adaptive Record
* Dependency Injection improvement on auto binding
* Job parameter binding improvement

0.4.0
* Performance tuning: enable direct io thread processing handler

0.3.1
* ActiveRecord -> AdaptiveRecord
* Performance tuning: enable nonblocking IO

0.3.0
* Catch up update to osgl-mvc 0.6.0: Bind annotation now support specifying multiple Binder implementations

0.2.0
* Make act be java 1.6 compatible
* Big refactoring on
 * dependency injection now on Genie
 * param loading mechanism
 * render arg enhancement now support method call with params, and field

0.1.3
* testapp to implement integration test of ActFramework

0.1.2
* misc bug fixes

0.1.1
* baseline version
