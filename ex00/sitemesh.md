```
10월 11, 2024 9:42:47 오전 org.apache.catalina.core.StandardContext filterStart
SEVERE: 필터 [sitemesh]을(를) 시작하는 중 오류 발생
java.lang.NullPointerException
at org.apache.catalina.core.DefaultInstanceManager.loadClass(DefaultInstanceManager.java:477)
	at org.apache.catalina.core.DefaultInstanceManager.loadClassMaybePrivileged(DefaultInstanceManager.java:470)
	at org.apache.catalina.core.DefaultInstanceManager.newInstance(DefaultInstanceManager.java:142)
	at org.apache.catalina.core.ApplicationFilterConfig.getFilter(ApplicationFilterConfig.java:224)
	at org.apache.catalina.core.ApplicationFilterConfig.<init>(ApplicationFilterConfig.java:97)
	at org.apache.catalina.core.StandardContext.filterStart(StandardContext.java:3856)
	at org.apache.catalina.core.StandardContext.startInternal(StandardContext.java:4474)
	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:164)
	at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1203)
	at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1193)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
	at org.apache.tomcat.util.threads.InlineExecutorService.execute(InlineExecutorService.java:75)
	at java.base/java.util.concurrent.AbstractExecutorService.submit(AbstractExecutorService.java:140)
	at org.apache.catalina.core.ContainerBase.startInternal(ContainerBase.java:749)
	at org.apache.catalina.core.StandardHost.startInternal(StandardHost.java:721)
	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:164)
	at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1203)
	at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1193)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
	at org.apache.tomcat.util.threads.InlineExecutorService.execute(InlineExecutorService.java:75)
	at java.base/java.util.concurrent.AbstractExecutorService.submit(AbstractExecutorService.java:140)
	at org.apache.catalina.core.ContainerBase.startInternal(ContainerBase.java:749)
	at org.apache.catalina.core.StandardEngine.startInternal(StandardEngine.java:211)
	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:164)
	at org.apache.catalina.core.StandardService.startInternal(StandardService.java:415)
	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:164)
	at org.apache.catalina.core.StandardServer.startInternal(StandardServer.java:878)
	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:164)
	at org.apache.catalina.startup.Catalina.start(Catalina.java:735)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at org.apache.catalina.startup.Bootstrap.start(Bootstrap.java:345)
	at org.apache.catalina.startup.Bootstrap.main(Bootstrap.java:473)

10월 11, 2024 9:42:47 오전 org.apache.catalina.core.StandardContext startInternal
SEVERE: 하나 이상의 필터들이 시작하지 못했습니다. 모든 상세 사항은 적절한 컨테이너 로그 파일에서 찾을 수 있습니다.
10월 11, 2024 9:42:47 오전 org.apache.catalina.core.StandardContext startInternal
SEVERE: 이전 오류들로 인해 컨텍스트 []의 시작이 실패했습니다.
```