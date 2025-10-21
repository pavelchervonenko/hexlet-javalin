package gg.jte.generated.ondemand.courses;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.courses.CoursesPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,11,11,11,11,13,13,13,13,13,13,13,13,13,14,14,14,14,14,14,14,14,14,18,18,20,20,21,21,23,23,23,24,24,24,26,26,27,27,29,29,29,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\r\n<html>\r\n    <head>\r\n        <meta charset=\"utf-8\" />\r\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n        <title>Хекслет</title>\r\n    </head>\r\n    <body>\r\n        <h1>");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(page.getHeader());
		jteOutput.writeContent("</h1>\r\n\r\n        <form");
		var __jte_html_attribute_0 = NamedRoutes.coursesPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" action=\"");
			jteOutput.setContext("form", "action");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("form", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" method=\"get\">\r\n          <input type=\"search\" name=\"term\"");
		var __jte_html_attribute_1 = page.getTerm();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" placeholder=\"Название или описание\">\r\n          <input type=\"submit\" value=\"Искать\">\r\n        </form>\r\n\r\n        ");
		if (page.getCourses().isEmpty()) {
			jteOutput.writeContent("\r\n            <p>Пока не добавлено ни одного курса</p>\r\n        ");
		} else {
			jteOutput.writeContent("\r\n            ");
			for (var course : page.getCourses()) {
				jteOutput.writeContent("\r\n               <div>\r\n                   <h2><a href=\"{NamedRoutes.coursePath(course.getId())}\">");
				jteOutput.setContext("a", null);
				jteOutput.writeUserContent(course.getName());
				jteOutput.writeContent("</a></h2>\r\n                   <p>");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(course.getDescription());
				jteOutput.writeContent("</p>\r\n               </div>\r\n            ");
			}
			jteOutput.writeContent("\r\n        ");
		}
		jteOutput.writeContent("\r\n    </body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
