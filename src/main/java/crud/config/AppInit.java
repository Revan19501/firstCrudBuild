package crud.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Указание классов конфигурации для Spring (для корневой части приложения)
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{AppConfig.class};  // Здесь можно указать конфигурацию для Hibernate и базы данных
    }

    // Указание классов конфигурации для DispatcherServlet (для конфигурации Spring MVC)
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};  // Подключение WebConfig с настройками для Thymeleaf
    }

    // Указание URL маппинга для DispatcherServlet
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};  // Все запросы обрабатываются через DispatcherServlet
    }
}