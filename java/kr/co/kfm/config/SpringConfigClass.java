package kr.co.kfm.config;
/*
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringConfigClass implements WebApplicationInitializer{

public class SpringConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer {
	// DispatcherServlet占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙청 占쌍소몌옙 占쏙옙占쏙옙占싼댐옙.
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		//占쏙옙占쏙옙占쌈울옙 환占썸설占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 클占쏙옙占쏙옙 占쏙옙체
		AnnotationConfigWebApplicationContext servletAppContext=new AnnotationConfigWebApplicationContext(); 
		//환占썸설占쏙옙 클占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占싸곤옙 占쏙옙占쏙옙占쏙옙 占싸듸옙풔占� 占쏙옙체(servletAppContext)
		servletAppContext.register(ServletAppContext.class);
		
		//占쏙옙청 占쌩삼옙占쏙옙 占쏙옙청占쏙옙 처占쏙옙占싹댐옙 占쏙옙占쏙옙占쏙옙占쏙옙 DispatcherServlet占쏙옙占쏙옙 占쏙옙占쏙옙
		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
		ServletRegistration.Dynamic servlet=servletContext.addServlet("dispatcher", dispatcherServlet);
	
		//占싸곤옙 占쏙옙占쏙옙
		servlet.setLoadOnStartup(1); //占쏙옙占쏙옙 占쏙옙占쏙옙 占싱곤옙체占쏙옙 占쏙옙占싸듸옙占쏙옙!!
		servlet.addMapping("/"); //  占쏙옙트占쏙옙 占싱듸옙
		
		//=========================================================
		//占쏙옙占쏙옙 占쌨몌옙 확占쏙옙
		AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
		rootAppContext.register(RootAppContext.class);
		
		//확占쏙옙占쏙옙 占쌨몌옙占쏙옙 占쏙옙체 占싸듸옙
		ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
		servletContext.addListener(listener);
		
		//dispatcher 占쏙옙 jsp... 占쏙옙占쏙옙占쏙옙占싹울옙 占쏙옙占쌔쇽옙 UTF-8占쏙옙 占쏙옙占쌘듸옙占싹댐옙 占쏙옙占싶곤옙체占쏙옙占쏙옙
		FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		filter.setInitParameter("encoding", "UTF-8");
		filter.addMappingForServletNames(null, false, "dispatcher");
		
	
	}

	// Spring MVC 占쏙옙占쏙옙占쏙옙트 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 클占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占싼댐옙.
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { ServletAppContext.class };
	}

	// 占쏙옙占쏙옙占쏙옙트占쏙옙占쏙옙 占쏙옙占쏙옙占� Bean占쏙옙占쏙옙 占쏙옙占실깍옙 占쏙옙占쏙옙 클占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占싼댐옙.
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { RootAppContext.class };
	}

	// 占식띰옙占쏙옙占� 占쏙옙占쌘듸옙 占쏙옙占쏙옙 占쏙옙占쏙옙
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] { encodingFilter };
	}
	// Multipart 占쏙옙占쏙옙占쏙옙占쏙옙
	// null: 占쏙옙占쏙옙微占� 占쌉뤄옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쌈시깍옙占쏙옙占� 占쏙옙占쏙옙치占쏙옙占십울옙占쏙옙 占쏙옙占쏙옙占싹댐옙 占쏙옙占쏙옙占쏙옙 占쌈시깍옙占쏙옙占쏙옙
	// 52428800 : 占쏙옙占싸듸옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쎈량 (1024*50) 50M占쏙옙 占쏙옙占쏙옙
	// 524288000 : 占쏙옙占싹듸옙占쏙옙占싶몌옙 占쏙옙占쏙옙占쏙옙 占쏙옙체占쎈량 500M 占쏙옙占쏙옙
	// 0 : 占쏙옙占쏙옙占쏙옙 占쌈계값

	@Override
	protected void customizeRegistration(Dynamic registration) {
		// TODO Auto-generated method stub
		super.customizeRegistration(registration);

		MultipartConfigElement config1 = new MultipartConfigElement(null, 52428800, 524288000, 0);
		registration.setMultipartConfig(config1);
	}
}
*/

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer {
	// DispatcherServlet에 매핑할 요청 주소를 셋팅한다.
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}

	// Spring MVC 프로젝트 설정을 위한 클래스를 지정한다.
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { ServletAppContext.class };
	}

	// 프로젝트에서 사용할 Bean들을 정의기 위한 클래스를 지정한다.
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { RootAppContext.class };
	}

	// 파라미터 인코딩 필터 설정
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] { encodingFilter };
	}
	// Multipart 정보구현
	// null: 사용자가 입력한 내용을 임시기억할 아파치톰켁에서 제공하는 서버의 임시기억장소
	// 52428800 : 업로드 데이터의 용량 (1024*50) 50M로 설정
	// 524288000 : 파일데이터를 포함한 전체용량 500M 설정
	// 0 : 파일의 임계값

	@Override
	protected void customizeRegistration(Dynamic registration) {
		// TODO Auto-generated method stub
		super.customizeRegistration(registration);

		MultipartConfigElement config1 = new MultipartConfigElement(null, 52428800, 524288000, 0);
		registration.setMultipartConfig(config1);
	}
}












