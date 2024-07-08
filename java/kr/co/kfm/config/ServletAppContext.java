package kr.co.kfm.config;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.kfm.beans.UserBean;
import kr.co.kfm.interceptor.CheckLoginInterceptor;
import kr.co.kfm.interceptor.MenuInterceptor;
import kr.co.kfm.mapper.AnalysisMapper;
import kr.co.kfm.mapper.BoardMapper;
import kr.co.kfm.mapper.GuMapper;
import kr.co.kfm.mapper.HistoryMapper;
import kr.co.kfm.mapper.IOMapper;
import kr.co.kfm.mapper.OrderSituationMapper;
import kr.co.kfm.mapper.ProductMapper;
import kr.co.kfm.mapper.SafetyMapper;
import kr.co.kfm.mapper.SellNBuyMapper;
import kr.co.kfm.mapper.UserMapper;

@Configuration
@EnableWebMvc
@ComponentScan("kr.co.kfm.dao")
@ComponentScan("kr.co.kfm.service")
@ComponentScan("kr.co.kfm.controller")
@PropertySource("/WEB-INF/properties/db.properties")
public class ServletAppContext implements WebMvcConfigurer {

	@Value("${db.classname}")
	private String db_classname;

	@Value("${db.url}")
	private String db_url;

	@Value("${db.username}")
	private String db_username;

	@Value("${db.password}")
	private String db_password;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	// jsp / html / css / js / jquery
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}

	// �뜲�씠�꽣踰좎씠�뒪 �젒�냽 �젙蹂대�� 愿�由ы븯�뒗 Bean
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName(db_classname);
		source.setUrl(db_url);
		source.setUsername(db_username);
		source.setPassword(db_password);

		return source;
	}

	// 쿼리문과 접속 정보를 관리하는 객체
	@Bean
	public SqlSessionFactory factory(BasicDataSource source) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(source);
		SqlSessionFactory factory = factoryBean.getObject();
		return factory;
	}

	@Bean
	public MapperFactoryBean<GuMapper> getGuMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<GuMapper> factoryBean = new MapperFactoryBean<GuMapper>(GuMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<ProductMapper> getProductMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<ProductMapper> factoryBean = new MapperFactoryBean<ProductMapper>(ProductMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<HistoryMapper> getHistoryMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<HistoryMapper> factoryBean = new MapperFactoryBean<HistoryMapper>(HistoryMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<SafetyMapper> getSafetyMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<SafetyMapper> factoryBean = new MapperFactoryBean<SafetyMapper>(SafetyMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<UserMapper> getUserMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<UserMapper> factoryBean = new MapperFactoryBean<>(UserMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<SellNBuyMapper> getSellNBuyMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<SellNBuyMapper> factoryBean = new MapperFactoryBean<SellNBuyMapper>(SellNBuyMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<AnalysisMapper> getAnalysisMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<AnalysisMapper> factoryBean = new MapperFactoryBean<AnalysisMapper>(AnalysisMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<BoardMapper> getBoardMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<BoardMapper> factoryBean = new MapperFactoryBean<BoardMapper>(BoardMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<OrderSituationMapper> getOrderSituationMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<OrderSituationMapper> factoryBean = new MapperFactoryBean<OrderSituationMapper>(
				OrderSituationMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
	
	@Bean
	public MapperFactoryBean<IOMapper> getIOMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<IOMapper> factoryBean = new MapperFactoryBean<IOMapper>(IOMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);
		
		CheckLoginInterceptor checkLoginInterCeptor = new CheckLoginInterceptor(loginUserBean);
		InterceptorRegistration reg1 = registry.addInterceptor(checkLoginInterCeptor);

		reg1.addPathPatterns("/analysis/*", "/board/*", "/data_management/*", "/hyeonmin/*","/orderSituation/*", "/sellNBuy/*");
		
		MenuInterceptor menuInterceptor = new MenuInterceptor(loginUserBean);
		InterceptorRegistration reg2 = registry.addInterceptor(menuInterceptor);
		reg2.addPathPatterns("/**");
	}

	// Properties 파일을 Bean으로 등록
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	// Properties Message �쐞移� 吏��젙�븯�뿬 �쑀�슚�꽦 寃��궗 �냼�뒪�뒗 紐⑤몢 �씠怨녹쓣 �씫怨� 媛��룄濡� �븿.
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
		res.setBasenames("/WEB-INF/properties/error_message");
		return res;
	}

	// enctype="multipart/form-data" 사용하기 위한 클래스 객체 생성
	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

}