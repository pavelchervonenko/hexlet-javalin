package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.NamedRoutes;
public final class JteshowGenerated {
	public static final String JTE_NAME = "courses/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,11,11,11,11,14,14,14,14,14,14,14,14,14,19,19,19,23,23,23,28,28,28,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursePage page) {
		jteOutput.writeContent("\r\n<html>\r\n    <head>\r\n        <meta charset=\"utf-8\" />\r\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n        <title>Хекслет</title>\r\n    </head>\r\n    <body>\r\n        <h1>Курс: ");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(page.getCourse().getName());
		jteOutput.writeContent("</h1>\r\n\r\n        <p>\r\n            <a");
		var __jte_html_attribute_0 = NamedRoutes.mainPagePath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Вернуться на главную</a>\r\n        </p>\r\n\r\n        <ul>\r\n            <li>\r\n                <p>Название - ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(page.getCourse().getName());
		jteOutput.writeContent("</p>\r\n            </li>\r\n            <li>\r\n                <p>Описание:</p>\r\n                <text>");
		jteOutput.setContext("text", null);
		jteOutput.writeUserContent(page.getCourse().getDescription());
		jteOutput.writeContent("</text>\r\n            </li>\r\n        </ul>\r\n\r\n    </body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursePage page = (CoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
