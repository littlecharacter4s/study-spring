# study-spring

Spring学习 - 基于注解

@Configuration + XxConfig(配置类) 代替 application-context.xml

```
AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(XxConfig.class);
代替
ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:application-context.xml");
```

## 1、study-spring-ioc

1. 单个Bean注入：@Bean
    - 在XxConfig类中的方法上使用；
    - 默认Bean的名称是方法名，@Bean("xx")可以显示指定
2. 包扫描：@ComponentScan(JDK8后可配置多个)、@ComponentScans
    - 可配置只包含（includeFilters）或不包含（excludeFilters）
    - 常用包含/排除方式：按注解（FilterType.ANNOTATION）、自定义TypeFilter
    - 常用@ComponentScan或者@ComponentScan + 自定义TypeFilter
3. 作用域：@Scope
    - singleton(默认)：单实例，ioc容器启动时会调用方法创建对象放到ioc容器中，以后每次获取就是直接从容器中拿
    - prototype：多实例，ioc容器启动时并不会去调用方法创建对象放在容器中，而是每次获取的时候才会调用方法创建对象
    - request：同一次请求创建一个实例
    - session：同一个session创建一个实例
4. 懒加载：@Lazy
    - 对单实例Bean而言，默认在容器启动的时候创建对象；而懒加载，容器启动时不创建对象，第一次使用(获取)Bean创建对象，并初始化
5. 按照条件注册Bean：@Conditional
    - 既可以放在类上，也可以放在方法上
    - SpringBoot内部有大量使用
6. 给容器导入外部组件：@Import
    - 第一种方式：直接导入
    - 第二种方式：实现ImportSelector接口，springboot中这种方式使用较多
    - 第三种方式：实现ImportBeanDefinitionRegistrar接口
7. 使用FactoryBean给容器注入Bean
    - 实现FactoryBean接口
    - 通过`applicationContext.getBean("xxFactoryBean")`获取注入的Bean
    - 通过`applicationContext.getBean("&xxFactoryBean")`获取xxFactoryBean本身
    > 为甚么要有FactoryBean？  
    它们隐藏了实例化一些复杂Bean的细节，给上层应用带来了便利。
8. Bean的生命周期 -> 注意singleton和prototype模式的区别
    - 第一种方式：指定初始化和销毁方法，例Lifecycle01
    - 第二种方式：实现InitializingBean和DisposableBean接口，例Lifecycle02
    - 第三种方式：使用@PostConstruct和@PreDestroy注解，例Lifecycle03
    - 第四种方式：使用Bean的的后置处理器接口，实现BeanPostProcessor接口，例CustomBeanPostProcessor，  
    只操作Lifecycle01、Lifecycle02、Lifecycle03，方便查看
9. 属性赋值：@Value
    - 赋基本数值：@Value("张三)、@Value(18)
    - SpEL赋值：@Value("#{20-2}")
    - 取配置文件赋值：@Value("${xx}")，需要结合@PropertySource({"classpath:common.properties"})
10. 自动装配：底层由AutowiredAnnotationBeanPostProcessor来实现
    - @Resource、@Autowired、@Qualifier、@Primary、@Inject等，不多说
11. 给Bean装配Spring底层组件
    - 实现xxAware接口，例SpringFactory
    - 底层都有xxAwareProcessor(响应的后置处理器)来处理
12. 根据环境注册Bean：@Profile
    - 其实不如maven的<profiles></profiles>来的好！见pom.xml，推荐

## 2、study-spring-aop

AopConfig配置类上标注@EnableAspectJAutoProxy代替之前xml中`<aop:aspectj-autoproxy/>`配置

> Spring AOP：指在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式  
> @Aspect：切面类  
> @Pointcut：切入点，@Pointcut+execution表达式或自定义注解来指定代理类和方法（切入点）  
> @切入点逻辑：
>> @Before：前置逻辑，在目标方法运行之前运行  
>> @After：后置逻辑，在目标方法运行结束之后运行（无论方法正常结束还是异常结束）  
>> @AfterReturning：返回逻辑，在目标方法正常返回之后运行  
>> @AfterThrowing：异常逻辑，在目标方法出现异常以后运行  
>> @Around：环绕逻辑，自行决定目标方法的运行时机(`joinPoint.procced()`)  

1. Spring AOP两种常用实现方式
    - 第一种：使用execution表达式（OrderAspect）
    - 第二种：使用自定义注解（AccountAspect + @Monitor）
2. Spring AOP三个实现步骤
    1. 将业务逻辑组件和切面类都加入到容器中；告诉Spring哪个是切面类（@Aspect）
    2. 在切面类上的每一个通知方法上标注通知注解，告诉Spring何时何地运行（切入点表达式）
    3. 开启基于注解的aop模式；@EnableAspectJAutoProxy
3. Spring AOP实现原理简单剖析

## 3、study-spring-tx
 
Spring Transaction，声明式事务  
@EnableTransactionManagement + TxConfig配置类中
```
    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
```
代替下面配置
```
<!-- 事务管理 : DataSourceTransactionManager -->
<bean id="txManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"/>
</bean>
<!-- 使用声明式事务:annotation -->
<tx:annotation-driven transaction-manager="txManager" />
``` 

1. @Transactional(rollbackFor=Exception.class)
    - 标注在要用声明式事务的方法上
    - Exception体系说明，见resource下的"Spring声明式事务与Java异常体系"
2. @Transactional原理简单剖析

## 4、study-spring-ext

1. Spring常用扩展点
    - BeanPostProcessor
    - BeanFactoryPostProcessor
    - BeanDefinitionRegistryPostProcessor
    - ApplicationListener
2. Spring扩展点原理
    - BeanPostProcessor原理
    - BeanFactoryPostProcessor原理
    - BeanDefinitionRegistryPostProcessor原理
    - ApplicationListener原理

## 5、study-spring-mvc

1. SpringMVC配置
    - DispatcherServlet配置，等价于web.xml中的配置  
    https://docs.spring.io/spring/docs/5.2.2.RELEASE/spring-framework-reference/web.html#mvc-servlet
    - MVC Config配置，等价于spring-mvc.xml配置  
    https://docs.spring.io/spring/docs/5.2.2.RELEASE/spring-framework-reference/web.html#mvc-config  
    注：官网的配置整合freemarker有问题，以此例中AppConfig.class为准
    - 赠品：SpringSecurity
2. SpringMVC原理
    1. web容器在启动的时候，会扫描每个jar包下的META-INF/services/javax.servlet.ServletContainerInitializer文件
    2. 加载这个文件指定的类：SpringServletContainerInitializer
        - 此类遵循Servlet3.1之后的运行时插件规范，实现了ServletContainerInitializer
        - 此类标有注解@HandlesTypes(WebApplicationInitializer.class)，
        会帮我们加载所有实现了WebApplicationInitializer的组件（非抽象类）并初始化，
        也就是本工程中的MyWebAppInitializer（MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer extends AbstractDispatcherServletInitializer extends AbstractContextLoaderInitializer implements WebApplicationInitializer）
    3. MyWebAppInitializer都干了啥（等价于web.xml干的活）
        - 创建根容器：createRootApplicationContext() 
            -> 进而调用getRootConfigClasses()，也就是MyWebAppInitializer的父类留给其实现的方法，用来传入spring ioc的配置类
        - 创建web的ioc容器：createServletApplicationContext()
            -> 进而调用getServletConfigClasses()，也就是MyWebAppInitializer的父类留给其实现的方法，用来传入spring mvc的配置类
        - 实现servlet mapping：getServletMappings()，供registerDispatcherServlet(ServletContext servletContext)调用
        - 等，主要就是上面三个