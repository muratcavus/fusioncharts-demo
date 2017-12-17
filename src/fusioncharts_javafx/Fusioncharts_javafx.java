
package fusioncharts_javafx;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author fusioncharts
 */
public class Fusioncharts_javafx extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		WebView myWebView = new WebView();
		final WebEngine engine = myWebView.getEngine();

		Button btn1 = new Button("Render Chart from file");
		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				File currDir = new File(".");
				String path = currDir.getAbsolutePath();
				path = path.substring(0, path.length() - 1);
				path = path.replaceAll("\\\\", "/");
				// System.out.println(path);

				File file = new File(path + "/src/fusioncharts_javafx/index.html");
				URL url;
				try {
					url = file.toURI().toURL();
					engine.load(url.toString());
				} catch (MalformedURLException ex) {
					Logger.getLogger(Fusioncharts_javafx.class.getName()).log(Level.SEVERE, null, ex);
				}

				// file:/C:/test/a.html

			}
		});

		Button btn2 = new Button("Render Chart from static string");
		btn2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				File currDir = new File(".");
				String path = currDir.getAbsolutePath();
				path = path.substring(0, path.length() - 1);
				path = path.replaceAll("\\\\", "/");
				// System.out.println(path);
				File fileFusionchartsjs = new File(path + "/src/fusioncharts_javafx/fusioncharts.js");
				File fileFusionchartsthemejs = new File(path + "/src/fusioncharts_javafx/fusioncharts.theme.fint.js");
				URL urlFusionchartsjs;
				URL urlFusionchartsthemejs;
				try {
					urlFusionchartsjs = fileFusionchartsjs.toURI().toURL();
					urlFusionchartsthemejs = fileFusionchartsthemejs.toURI().toURL();
					engine.loadContent("<html>\n" + "<head>\n"
							+ "<title>My first chart using FusionCharts Suite XT</title>\n"
							+ "<script type=\"text/javascript\" src=\"" + urlFusionchartsjs.toString()
							+ "\"></script>\n" + "<script type=\"text/javascript\" src=\""
							+ urlFusionchartsthemejs.toString() + "\"></script>\n"
							+ "<script type=\"text/javascript\">\n" + "FusionCharts.ready(function () {\n"
							+ "    var revenueChart = new FusionCharts({\n" + "        type: 'doughnut2d',\n"
							+ "        renderAt: 'chart-container',\n" + "        width: '450',\n"
							+ "        height: '450',\n" + "        dataFormat: 'json',\n" + "        dataSource: {\n"
							+ "            \"chart\": {\n"
							+ "                \"caption\": \"Split of Revenue by Product Categories\",\n"
							+ "                \"subCaption\": \"Last year\",\n"
							+ "                \"numberPrefix\": \"$\",\n"
							+ "                \"paletteColors\": \"#0075c2,#1aaf5d,#f2c500,#f45b00,#8e0000\",\n"
							+ "                \"bgColor\": \"#ffffff\",\n" + "                \"showBorder\": \"0\",\n"
							+ "                \"use3DLighting\": \"0\",\n" + "                \"showShadow\": \"0\",\n"
							+ "                \"enableSmartLabels\": \"0\",\n"
							+ "                \"startingAngle\": \"310\",\n"
							+ "                \"showLabels\": \"0\",\n"
							+ "                \"showPercentValues\": \"1\",\n"
							+ "                \"showLegend\": \"1\",\n" + "                \"legendShadow\": \"0\",\n"
							+ "                \"legendBorderAlpha\": \"0\",\n"
							+ "                \"defaultCenterLabel\": \"Total revenue: $64.08K\",\n"
							+ "                \"centerLabel\": \"Revenue from $label: $value\",\n"
							+ "                \"centerLabelBold\": \"1\",\n"
							+ "                \"showTooltip\": \"0\",\n" + "                \"decimals\": \"0\",\n"
							+ "                \"captionFontSize\": \"14\",\n"
							+ "                \"subcaptionFontSize\": \"14\",\n"
							+ "                \"subcaptionFontBold\": \"0\"\n" + "            },\n"
							+ "            \"data\": [\n" + "                {\n"
							+ "                    \"label\": \"Food\",\n"
							+ "                    \"value\": \"28504\"\n" + "                }, \n"
							+ "                {\n" + "                    \"label\": \"Apparels\",\n"
							+ "                    \"value\": \"14633\"\n" + "                }, \n"
							+ "                {\n" + "                    \"label\": \"Electronics\",\n"
							+ "                    \"value\": \"10507\"\n" + "                }, \n"
							+ "                {\n" + "                    \"label\": \"Household\",\n"
							+ "                    \"value\": \"4910\"\n" + "                }\n" + "            ]\n"
							+ "        }\n" + "    }).render();\n" + "});\n" + "</script>\n" + "</head>\n" + "<body>\n"
							+ "  <div id=\"chart-container\">FusionCharts XT will load here!</div>\n"
							+ "<div> Loaded from a string </div>\n" + "</body>\n" + "</html>");
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Button btn3 = new Button("Render Chart from static another string");
		btn3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				File currDir = new File(".");
				String path = currDir.getAbsolutePath();
				path = path.substring(0, path.length() - 1);
				path = path.replaceAll("\\\\", "/");
				// System.out.println(path);
				File fileFusionchartsjs = new File(path + "/src/fusioncharts_javafx/fusioncharts.js");
				File fileFusionchartschartsjs = new File(path + "/src/fusioncharts_javafx/fusioncharts.charts.fint.js");
				URL urlFusionchartsjs;
				URL urlFusionchartsthemejs;
				try {
					urlFusionchartsjs = fileFusionchartsjs.toURI().toURL();
					urlFusionchartsthemejs = fileFusionchartschartsjs.toURI().toURL();
					engine.loadContent("<html>\n" + "<head>\n"
							+ "<title>My first chart using FusionCharts Suite XT</title>\n"
							+ "<script type=\"text/javascript\" src=\"" + urlFusionchartsjs.toString()
							+ "\"></script>\n" + "<script type=\"text/javascript\" src=\""
							+ urlFusionchartsthemejs.toString() + "\"></script>\n"
							+ "<script type=\"text/javascript\">\n" 
							
							+ "FusionCharts.ready(function () {\r\n" + 
							"    var analysisChart = new FusionCharts({\r\n" + 
							"        type: 'stackedColumn3DLine',\r\n" + 
							"        renderAt: 'chart-container',\r\n" + 
							"        width: '500',\r\n" + 
							"        height: '350',\r\n" + 
							"        dataFormat: 'json',\r\n" + 
							"        dataSource: {\r\n" + 
							"            \"chart\": {\r\n" + 
							"                \"showvalues\": \"0\",\r\n" + 
							"                \"caption\": \"Cost Analysis\",\r\n" + 
							"                \"numberprefix\": \"$\",\r\n" + 
							"                \"xaxisname\": \"Quarters\",\r\n" + 
							"                \"yaxisname\": \"Cost\",\r\n" + 
							"                \"showBorder\": \"0\",\r\n" + 
							"                \"paletteColors\": \"#0075c2,#1aaf5d,#f2c500\",\r\n" + 
							"                \"bgColor\": \"#ffffff\",\r\n" + 
							"                \"canvasBgColor\": \"#ffffff\",\r\n" + 
							"                \"captionFontSize\": \"14\",\r\n" + 
							"                \"subcaptionFontSize\": \"14\",\r\n" + 
							"                \"subcaptionFontBold\": \"0\",\r\n" + 
							"                \"divlineColor\": \"#999999\",\r\n" + 
							"                \"divLineIsDashed\": \"1\",\r\n" + 
							"                \"divLineDashLen\": \"1\",\r\n" + 
							"                \"divLineGapLen\": \"1\",\r\n" + 
							"                \"toolTipColor\": \"#ffffff\",\r\n" + 
							"                \"toolTipBorderThickness\": \"0\",\r\n" + 
							"                \"toolTipBgColor\": \"#000000\",\r\n" + 
							"                \"toolTipBgAlpha\": \"80\",\r\n" + 
							"                \"toolTipBorderRadius\": \"2\",\r\n" + 
							"                \"toolTipPadding\": \"5\",\r\n" + 
							"                \"legendBgColor\": \"#ffffff\",\r\n" + 
							"                \"legendBorderAlpha\": '0',\r\n" + 
							"                \"legendShadow\": '0',\r\n" + 
							"                \"legendItemFontSize\": '10',\r\n" + 
							"                \"legendItemFontColor\": '#666666'\r\n" + 
							"            },\r\n" + 
							"            \"categories\": [\r\n" + 
							"                {\r\n" + 
							"                    \"category\": [\r\n" + 
							"                        {\r\n" + 
							"                            \"label\": \"Quarter 1\"\r\n" + 
							"                        },\r\n" + 
							"                        {\r\n" + 
							"                            \"label\": \"Quarter 2\"\r\n" + 
							"                        },\r\n" + 
							"                        {\r\n" + 
							"                            \"label\": \"Quarter 3\"\r\n" + 
							"                        },\r\n" + 
							"                        {\r\n" + 
							"                            \"label\": \"Quarter 4\"\r\n" + 
							"                        }\r\n" + 
							"                    ]\r\n" + 
							"                }\r\n" + 
							"            ],\r\n" + 
							"            \"dataset\": [\r\n" + 
							"                {\r\n" + 
							"                    \"seriesname\": \"Fixed Cost\",\r\n" + 
							"                    \"data\": [\r\n" + 
							"                        {\r\n" + 
							"                            \"value\": \"235000\"\r\n" + 
							"                        },\r\n" + 
							"                        {\r\n" + 
							"                            \"value\": \"225100\"\r\n" + 
							"                        },\r\n" + 
							"                        {\r\n" + 
							"                            \"value\": \"222000\"\r\n" + 
							"                        },\r\n" + 
							"                        {\r\n" + 
							"                            \"value\": \"230500\"\r\n" + 
							"                        }\r\n" + 
							"                    ]\r\n" + 
							"                },\r\n" + 
							"                {\r\n" + 
							"                    \"seriesname\": \"Variable Cost\",\r\n" + 
							"                    \"data\": [\r\n" + 
							"                        {\r\n" + 
							"                            \"value\": \"230000\"\r\n" + 
							"                        },\r\n" + 
							"                        {\r\n" + 
							"                            \"value\": \"143000\"\r\n" + 
							"                        },\r\n" + 
							"                        {\r\n" + 
							"                            \"value\": \"198000\"\r\n" + 
							"                        },\r\n" + 
							"                        {\r\n" + 
							"                            \"value\": \"327600\"\r\n" + 
							"                        }\r\n" + 
							"                    ]\r\n" + 
							"                },\r\n" + 
							"                {\r\n" + 
							"                    \"seriesname\": \"Budgeted cost\",\r\n" + 
							"                    \"renderas\": \"Line\",\r\n" + 
							"                    \"data\": [\r\n" + 
							"                        {\r\n" + 
							"                            \"value\": \"455000\"\r\n" + 
							"                        },\r\n" + 
							"                        {\r\n" + 
							"                            \"value\": \"334000\"\r\n" + 
							"                        },\r\n" + 
							"                        {\r\n" + 
							"                            \"value\": \"426000\"\r\n" + 
							"                        },\r\n" + 
							"                        {\r\n" + 
							"                            \"value\": \"403000\"\r\n" + 
							"                        }\r\n" + 
							"                    ]\r\n" + 
							"                }\r\n" + 
							"            ]\r\n" + 
							"        }\r\n" + 
							"    }).render();\r\n" + 
							"});" 
							
							+ "</script>\n" 
							+ "</head>\n" 
							+ "<body>\n"
							
							+ "<div id=\"chart-container\">FusionCharts XT will load here!</div>\n"
							+ "<div> Loaded from a string </div>\n" 
							
							+ "</body>\n" 
							+ "</html>");
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		VBox root = new VBox();
		root.getChildren().addAll(myWebView, btn1, btn2, btn3);

		Scene scene = new Scene(root, 700, 510);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
