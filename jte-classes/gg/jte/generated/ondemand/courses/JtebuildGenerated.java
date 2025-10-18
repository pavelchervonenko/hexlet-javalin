package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.BuildCoursePage;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "courses/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,11,11,11,13,13,14,14,15,15,15,16,16,17,17,19,19,25,25,25,25,25,25,25,25,25,31,31,31,31,31,31,31,31,31,39,39,39,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildCoursePage page) {
		jteOutput.writeContent("\r\n<html>\r\n    <head>\r\n        <meta charset=\"utf-8\" />\r\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n        <title>Хекслет</title>\r\n    </head>\r\n    <body>\r\n\r\n         ");
		if (page.getErrors() != null) {
			jteOutput.writeContent("\r\n              <ul>\r\n                  ");
			for (var validator : page.getErrors().values()) {
				jteOutput.writeContent("\r\n                      ");
				for (var error : validator) {
					jteOutput.writeContent("\r\n                          <li>");
					jteOutput.setContext("li", null);
					jteOutput.writeUserContent(error.getMessage());
					jteOutput.writeContent("</li>\r\n                      ");
				}
				jteOutput.writeContent("\r\n                  ");
			}
			jteOutput.writeContent("\r\n              </ul>\r\n          ");
		}
		jteOutput.writeContent("\r\n\r\n        <form action=\"/courses\" method=\"post\">\r\n          <div>\r\n            <label>\r\n              Название\r\n              <input type=\"text\" name=\"name\"");
		var __jte_html_attribute_0 = page.getName();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" />\r\n            </label>\r\n          </div>\r\n          <div>\r\n            <label>\r\n              Описание\r\n              <input type=\"text\" required name=\"description\"");
		var __jte_html_attribute_1 = page.getDescription();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" />\r\n            </label>\r\n          </div>\r\n          <input type=\"submit\" value=\"Добавить\" />\r\n        </form>\r\n\r\n    </body>\r\n</html>\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildCoursePage page = (BuildCoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
