package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,11,11,28,67,67,67,71,71,71,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content) {
		jteOutput.writeContent("\r\n<!doctype html>\r\n<html lang=\"en\">\r\n    <head>\r\n        <meta charset=\"utf-8\" />\r\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n        <title>Website layout</title>\r\n\r\n        <style>\r\n            ");
		jteOutput.writeContent("\r\n            * { box-sizing: border-box; }\r\n            html, body { margin: 0; padding: 0; }\r\n\r\n            .topbar {\r\n              width: 100%;\r\n              position: sticky;\r\n              top: 0;\r\n              display: flex;\r\n              align-items: center;\r\n              justify-content: space-between;\r\n              padding: 12px 20px;\r\n              border-bottom: 1px solid #e5e7eb;\r\n              background: #ffffff;\r\n            }\r\n\r\n            .brand {\r\n              font-size: 1.125rem;      ");
		jteOutput.writeContent("\r\n              font-weight: 700;\r\n              margin: 0;\r\n            }\r\n\r\n            .nav {\r\n              display: flex;\r\n              gap: 16px;\r\n            }\r\n\r\n            .nav a {\r\n              text-decoration: none;\r\n              color: #111827;\r\n              font-weight: 500;\r\n            }\r\n\r\n            .nav a:hover {\r\n              text-decoration: underline;\r\n            }\r\n\r\n            .container {\r\n              max-width: 960px;\r\n              margin: 24px auto;\r\n              padding: 0 16px;\r\n            }\r\n        </style>\r\n\r\n    </head>\r\n    <body>\r\n        <header class=\"topbar\" role=\"banner\">\r\n          <h1 class=\"brand\">Макет</h1>\r\n          <nav class=\"nav\" role=\"navigation\" aria-label=\"Main navigation\">\r\n            <a href=\"/main-page\">Главная</a>\r\n            <a href=\"/courses\">Курсы</a>\r\n            <a href=\"/users\">Пользователи</a>\r\n          </nav>\r\n        </header>\r\n\r\n        <main class=\"container\">\r\n            ");
		jteOutput.setContext("main", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\r\n        </main>\r\n\r\n    </body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		render(jteOutput, jteHtmlInterceptor, content);
	}
}
