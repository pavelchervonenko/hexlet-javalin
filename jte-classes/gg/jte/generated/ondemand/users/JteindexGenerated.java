package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,14,14,14,16,16,16,18,18,23,23,23,23,23,23,23,23,23,27,27,27,27,27,27,27,27,27,30,30,32,32,34,34,36,36,36,36,36,36,36,36,36,36,36,36,37,37,37,39,39,41,41,43,43,43,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\r\n<html>\r\n    <head>\r\n        <meta charset=\"utf-8\" />\r\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n        <title>Хекслет</title>\r\n        <link\r\n          href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\"\r\n          rel=\"stylesheet\">\r\n    </head>\r\n    <body>\r\n        ");
		if (page.getFlash() != null) {
			jteOutput.writeContent("\r\n            <div class=\"alert alert-success\" role=\"alert\">\r\n                ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(page.getFlash());
			jteOutput.writeContent("\r\n            </div>\r\n        ");
		}
		jteOutput.writeContent("\r\n\r\n        <h1>Пользователи</h1>\r\n\r\n        <p>\r\n            <a");
		var __jte_html_attribute_0 = NamedRoutes.buildUserPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Создать пользователя</a>\r\n        </p>\r\n\r\n        <p>\r\n            <a");
		var __jte_html_attribute_1 = NamedRoutes.mainPagePath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">На главную</a>\r\n        </p>\r\n\r\n        ");
		if (page.getUsers().isEmpty()) {
			jteOutput.writeContent("\r\n            <p>Пока не добавлено ни одного пользователя</p>\r\n        ");
		} else {
			jteOutput.writeContent("\r\n            <ul>\r\n            ");
			for (var user : page.getUsers()) {
				jteOutput.writeContent("\r\n                <li>\r\n                    <a");
				var __jte_html_attribute_2 = NamedRoutes.userPath(user.getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_2);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">");
				jteOutput.setContext("a", null);
				jteOutput.writeUserContent(user.getName());
				jteOutput.writeContent("</a>\r\n                    - ");
				jteOutput.setContext("li", null);
				jteOutput.writeUserContent(user.getEmail());
				jteOutput.writeContent("\r\n                </li>\r\n            ");
			}
			jteOutput.writeContent("\r\n            </ul>\r\n        ");
		}
		jteOutput.writeContent("\r\n    </body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
