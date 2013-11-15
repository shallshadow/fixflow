package com.founder.fix.fixflow.editor;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.codehaus.jackson.node.ObjectNode;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.RootElement;
import org.eclipse.bpmn2.di.BpmnDiPackage;
import org.eclipse.bpmn2.util.Bpmn2ResourceFactoryImpl;
import org.eclipse.dd.dc.DcPackage;
import org.eclipse.dd.di.DiPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.founder.fix.bpmn2extensions.fixflow.FixFlowPackage;
import com.founder.fix.fixflow.core.ModelService;
import com.founder.fix.fixflow.core.ProcessEngine;
import com.founder.fix.fixflow.core.ProcessEngineManagement;
import com.founder.fix.fixflow.core.exception.FixFlowException;
import com.founder.fix.fixflow.core.impl.ExternalContent;
import com.founder.fix.fixflow.core.impl.bpmn.behavior.DefinitionsBehavior;
import com.founder.fix.fixflow.core.impl.bpmn.behavior.ProcessDefinitionBehavior;
import com.founder.fix.fixflow.core.impl.util.ReflectUtil;

/**
 * Servlet implementation class ModelConverter
 */
public class ModelConverter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static int BUFFER_SIZE = 4096;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModelConverter() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String t1 = request.getParameter("t1");
		System.out.println(t1);
		// TODO Auto-generated method stub
//		String aa = "{\"name\":\"Demo model\",\"description\":\"This is a demo model\",\"modelId\":\"50\",\"model\":{\"bounds\":{\"lowerRight\":{\"x\":1485,\"y\":1050},\"upperLeft\":{\"x\":0,\"y\":0}},\"childShapes\":[{\"bounds\":{\"lowerRight\":{\"x\":169.5,\"y\":160},\"upperLeft\":{\"x\":139.5,\"y\":130}},\"childShapes\":[],\"dockers\":[],\"outgoing\":[{\"resourceId\":\"sid-974EF4BD-0E76-4983-B84D-FA92053B98DC\"}],\"properties\":{\"bgcolor\":\"#ffffff\",\"bordercolor\":\"#000000\",\"dataoutput\":\"\",\"dataoutputassociations\":\"\",\"documentation\":\"\",\"executionlisteners\":\"\",\"formproperties\":\"\",\"initiator\":\"\",\"name\":\"\",\"outputset\":\"\",\"processid\":\"\",\"trigger\":\"None\"},\"resourceId\":\"sid-2BB933AE-E0AE-48D2-9ACC-B5EC35AD3687\",\"stencil\":{\"id\":\"StartNoneEvent\"}},{\"bounds\":{\"lowerRight\":{\"x\":325,\"y\":185},\"upperLeft\":{\"x\":225,\"y\":105}},\"childShapes\":[],\"dockers\":[],\"outgoing\":[{\"resourceId\":\"sid-AFFB5C18-4C31-469B-919B-A08BE34542EA\"}],\"properties\":{\"asynchronousdefinition\":\"No\",\"bgcolor\":\"#ffffcc\",\"bordercolor\":\"#000000\",\"callacitivity\":\"\",\"completioncondition\":\"\",\"documentation\":\"\",\"duedatedefinition\":\"\",\"exclusivedefinition\":\"Yes\",\"executionlisteners\":\"\",\"formkeydefinition\":\"\",\"formproperties\":{\"items\":[{\"formproperty_id\":\"number\",\"formproperty_name\":\"Number\",\"formproperty_type\":\"long\"},{\"formproperty_id\":\"message\",\"formproperty_name\":\"Message\",\"formproperty_type\":\"string\"}],\"totalCount\":2},\"inputdataitem\":\"\",\"isforcompensation\":\"\",\"loopcardinality\":\"\",\"loopcondition\":\"\",\"loopmaximum\":\"\",\"looptype\":\"None\",\"name\":\"user task 1\",\"prioritydefinition\":\"\",\"processid\":\"\",\"properties\":\"\",\"tasklisteners\":\"\",\"usertaskassignment\":{\"items\":[{\"assignment_type\":\"assignee\",\"resourceassignmentexpr\":\"kermit\"}],\"totalCount\":1}},\"resourceId\":\"sid-AFE2BB40-CF6F-4947-9DF9-2F1F80E34C43\",\"stencil\":{\"id\":\"UserTask\"}},{\"bounds\":{\"lowerRight\":{\"x\":224.10546875,\"y\":145},\"upperLeft\":{\"x\":169.62109375,\"y\":145}},\"childShapes\":[],\"dockers\":[{\"x\":15,\"y\":15},{\"x\":50,\"y\":40}],\"outgoing\":[{\"resourceId\":\"sid-AFE2BB40-CF6F-4947-9DF9-2F1F80E34C43\"}],\"properties\":{\"bordercolor\":\"#000000\",\"conditionalflow\":\"None\",\"conditionexpression\":\"\",\"conditionsequenceflow\":\"\",\"conditiontype\":\"None\",\"defaultflow\":\"None\",\"documentation\":\"\",\"isimmediate\":\"\",\"name\":\"\",\"showdiamondmarker\":\"\"},\"resourceId\":\"sid-974EF4BD-0E76-4983-B84D-FA92053B98DC\",\"stencil\":{\"id\":\"SequenceFlow\"},\"target\":{\"resourceId\":\"sid-AFE2BB40-CF6F-4947-9DF9-2F1F80E34C43\"}},{\"bounds\":{\"lowerRight\":{\"x\":430,\"y\":165},\"upperLeft\":{\"x\":390,\"y\":125}},\"childShapes\":[],\"dockers\":[],\"outgoing\":[{\"resourceId\":\"sid-07A7E174-8857-4DE9-A7CD-A041706D79C3\"},{\"resourceId\":\"sid-C2068B1E-9A82-41C9-B876-C58E2736C186\"}],\"properties\":{\"documentation\":\"\",\"name\":\"\"},\"resourceId\":\"sid-B074A0DD-934A-4053-A537-20ADF0781023\",\"stencil\":{\"id\":\"ExclusiveGateway\"}},{\"bounds\":{\"lowerRight\":{\"x\":389.3867255581166,\"y\":145.42209123822184},\"upperLeft\":{\"x\":325.7538994418834,\"y\":145.18728376177816}},\"childShapes\":[],\"dockers\":[{\"x\":50,\"y\":40},{\"x\":20.5,\"y\":20.5}],\"outgoing\":[{\"resourceId\":\"sid-B074A0DD-934A-4053-A537-20ADF0781023\"}],\"properties\":{\"bordercolor\":\"#000000\",\"conditionalflow\":\"None\",\"conditionexpression\":\"\",\"conditionsequenceflow\":\"\",\"conditiontype\":\"None\",\"defaultflow\":\"None\",\"documentation\":\"\",\"isimmediate\":\"\",\"name\":\"\",\"showdiamondmarker\":false},\"resourceId\":\"sid-AFFB5C18-4C31-469B-919B-A08BE34542EA\",\"stencil\":{\"id\":\"SequenceFlow\"},\"target\":{\"resourceId\":\"sid-B074A0DD-934A-4053-A537-20ADF0781023\"}},{\"bounds\":{\"lowerRight\":{\"x\":575,\"y\":110},\"upperLeft\":{\"x\":475,\"y\":30}},\"childShapes\":[],\"dockers\":[],\"outgoing\":[{\"resourceId\":\"sid-5DC9E5BB-634D-43BE-BE09-2A4D1A77AB3B\"}],\"properties\":{\"asynchronousdefinition\":\"No\",\"documentation\":\"\",\"duedatedefinition\":\"\",\"exclusivedefinition\":\"Yes\",\"executionlisteners\":\"\",\"formkeydefinition\":\"\",\"formproperties\":\"\",\"isforcompensation\":\"false\",\"looptype\":\"None\",\"name\":\"User task 2\",\"prioritydefinition\":\"\",\"tasklisteners\":\"\",\"usertaskassignment\":{\"items\":[{\"assignment_type\":\"assignee\",\"resourceassignmentexpr\":\"kermit\"}],\"totalCount\":1}},\"resourceId\":\"sid-03BC7128-4496-4027-88A9-E67D3DA63734\",\"stencil\":{\"id\":\"UserTask\"}},{\"bounds\":{\"lowerRight\":{\"x\":575,\"y\":260},\"upperLeft\":{\"x\":475,\"y\":180}},\"childShapes\":[],\"dockers\":[],\"outgoing\":[{\"resourceId\":\"sid-CBE1C51A-408E-4383-9D42-713450DD89BE\"}],\"properties\":{\"asynchronousdefinition\":\"No\",\"documentation\":\"\",\"duedatedefinition\":\"\",\"exclusivedefinition\":\"Yes\",\"executionlisteners\":\"\",\"formkeydefinition\":\"\",\"formproperties\":\"\",\"isforcompensation\":\"false\",\"looptype\":\"None\",\"name\":\"User task 3\",\"prioritydefinition\":\"\",\"tasklisteners\":\"\",\"usertaskassignment\":{\"items\":[{\"assignment_type\":\"assignee\",\"resourceassignmentexpr\":\"kermit\"}],\"totalCount\":1}},\"resourceId\":\"sid-7581049C-894E-4FF9-B861-7DF44B7229E3\",\"stencil\":{\"id\":\"UserTask\"}},{\"bounds\":{\"lowerRight\":{\"x\":670,\"y\":165},\"upperLeft\":{\"x\":630,\"y\":125}},\"childShapes\":[],\"dockers\":[],\"outgoing\":[{\"resourceId\":\"sid-7A6FDAE1-C837-4148-AE9E-E36F9BD55C27\"}],\"properties\":{\"documentation\":\"\",\"name\":\"\"},\"resourceId\":\"sid-6151821D-C3F9-4DFB-82EE-43885200535F\",\"stencil\":{\"id\":\"ExclusiveGateway\"}},{\"bounds\":{\"lowerRight\":{\"x\":650.5,\"y\":220},\"upperLeft\":{\"x\":575.0234375,\"y\":165.125}},\"childShapes\":[],\"dockers\":[{\"x\":50,\"y\":40},{\"x\":650.5,\"y\":220},{\"x\":20.5,\"y\":20.5}],\"outgoing\":[{\"resourceId\":\"sid-6151821D-C3F9-4DFB-82EE-43885200535F\"}],\"properties\":{\"conditionalflow\":\"None\",\"conditionsequenceflow\":\"\",\"defaultflow\":\"None\",\"documentation\":\"\",\"name\":\"\"},\"resourceId\":\"sid-CBE1C51A-408E-4383-9D42-713450DD89BE\",\"stencil\":{\"id\":\"SequenceFlow\"},\"target\":{\"resourceId\":\"sid-6151821D-C3F9-4DFB-82EE-43885200535F\"}},{\"bounds\":{\"lowerRight\":{\"x\":650,\"y\":125.25},\"upperLeft\":{\"x\":575.8046875,\"y\":70}},\"childShapes\":[],\"dockers\":[{\"x\":50,\"y\":40},{\"x\":650,\"y\":70},{\"x\":20,\"y\":20}],\"outgoing\":[{\"resourceId\":\"sid-6151821D-C3F9-4DFB-82EE-43885200535F\"}],\"properties\":{\"conditionalflow\":\"None\",\"conditionsequenceflow\":\"\",\"defaultflow\":\"None\",\"documentation\":\"\",\"name\":\"\"},\"resourceId\":\"sid-5DC9E5BB-634D-43BE-BE09-2A4D1A77AB3B\",\"stencil\":{\"id\":\"SequenceFlow\"},\"target\":{\"resourceId\":\"sid-6151821D-C3F9-4DFB-82EE-43885200535F\"}},{\"bounds\":{\"lowerRight\":{\"x\":765,\"y\":160},\"upperLeft\":{\"x\":735,\"y\":130}},\"childShapes\":[],\"dockers\":[{\"x\":750,\"y\":145}],\"outgoing\":[{\"resourceId\":\"sid-104B63DD-B61E-4D47-B65F-95A1B77AB041\"}],\"properties\":{\"documentation\":\"\",\"executionlisteners\":\"\",\"name\":\"\",\"timercycledefinition\":\"\",\"timerdatedefinition\":\"\",\"timerdurationdefinition\":\"PT5M\"},\"resourceId\":\"sid-C102D215-8257-40B4-AEE6-99B223204F7B\",\"stencil\":{\"id\":\"CatchTimerEvent\"}},{\"bounds\":{\"lowerRight\":{\"x\":734.2304813757047,\"y\":145.4012249378176},\"upperLeft\":{\"x\":670.1562373742953,\"y\":145.0792438121824}},\"childShapes\":[],\"dockers\":[{\"x\":20.5,\"y\":20.5},{\"x\":15,\"y\":15}],\"outgoing\":[{\"resourceId\":\"sid-C102D215-8257-40B4-AEE6-99B223204F7B\"}],\"properties\":{\"conditionalflow\":\"None\",\"conditionsequenceflow\":\"\",\"defaultflow\":\"None\",\"documentation\":\"\",\"name\":\"\"},\"resourceId\":\"sid-7A6FDAE1-C837-4148-AE9E-E36F9BD55C27\",\"stencil\":{\"id\":\"SequenceFlow\"},\"target\":{\"resourceId\":\"sid-C102D215-8257-40B4-AEE6-99B223204F7B\"}},{\"bounds\":{\"lowerRight\":{\"x\":838,\"y\":159},\"upperLeft\":{\"x\":810,\"y\":131}},\"childShapes\":[],\"dockers\":[],\"outgoing\":[],\"properties\":{\"documentation\":\"\",\"executionlisteners\":\"\",\"name\":\"\"},\"resourceId\":\"sid-65043A85-6BAD-4616-AD1E-FF3FA8D64D4B\",\"stencil\":{\"id\":\"EndNoneEvent\"}},{\"bounds\":{\"lowerRight\":{\"x\":809.125,\"y\":145},\"upperLeft\":{\"x\":765.453125,\"y\":145}},\"childShapes\":[],\"dockers\":[{\"x\":15,\"y\":15},{\"x\":14,\"y\":14}],\"outgoing\":[{\"resourceId\":\"sid-65043A85-6BAD-4616-AD1E-FF3FA8D64D4B\"}],\"properties\":{\"conditionalflow\":\"None\",\"conditionsequenceflow\":\"\",\"defaultflow\":\"None\",\"documentation\":\"\",\"name\":\"\"},\"resourceId\":\"sid-104B63DD-B61E-4D47-B65F-95A1B77AB041\",\"stencil\":{\"id\":\"SequenceFlow\"},\"target\":{\"resourceId\":\"sid-65043A85-6BAD-4616-AD1E-FF3FA8D64D4B\"}},{\"bounds\":{\"lowerRight\":{\"x\":474.80078125,\"y\":124.4453125},\"upperLeft\":{\"x\":410.5,\"y\":70}},\"childShapes\":[],\"dockers\":[{\"x\":20.5,\"y\":20.5},{\"x\":410.5,\"y\":70},{\"x\":50,\"y\":40}],\"outgoing\":[{\"resourceId\":\"sid-03BC7128-4496-4027-88A9-E67D3DA63734\"}],\"properties\":{\"conditionalflow\":\"None\",\"conditionsequenceflow\":\"${number > 1}\",\"defaultflow\":\"None\",\"documentation\":\"\",\"name\":\"\"},\"resourceId\":\"sid-07A7E174-8857-4DE9-A7CD-A041706D79C3\",\"stencil\":{\"id\":\"SequenceFlow\"},\"target\":{\"resourceId\":\"sid-03BC7128-4496-4027-88A9-E67D3DA63734\"}},{\"bounds\":{\"lowerRight\":{\"x\":474.80078125,\"y\":220},\"upperLeft\":{\"x\":410.5,\"y\":165.125}},\"childShapes\":[],\"dockers\":[{\"x\":20.5,\"y\":20.5},{\"x\":410.5,\"y\":220},{\"x\":50,\"y\":40}],\"outgoing\":[{\"resourceId\":\"sid-7581049C-894E-4FF9-B861-7DF44B7229E3\"}],\"properties\":{\"conditionalflow\":\"None\",\"conditionsequenceflow\":\"${number <= 1}\",\"defaultflow\":\"None\",\"documentation\":\"\",\"name\":\"\"},\"resourceId\":\"sid-C2068B1E-9A82-41C9-B876-C58E2736C186\",\"stencil\":{\"id\":\"SequenceFlow\"},\"target\":{\"resourceId\":\"sid-7581049C-894E-4FF9-B861-7DF44B7229E3\"}}],\"properties\":{\"author\":\"\",\"creationdate\":\"\",\"documentation\":\"\",\"executionlisteners\":\"\",\"expressionlanguage\":\"http://www.w3.org/1999/XPath\",\"modificationdate\":\"\",\"name\":\"\",\"orientation\":\"horizontal\",\"process_author\":\"\",\"process_id\":\"process\",\"process_namespace\":\"http://www.activiti.org/processdef\",\"process_version\":\"\",\"targetnamespace\":\"http://www.activiti.org/processdef\",\"typelanguage\":\"http://www.w3.org/2001/XMLSchema\",\"version\":\"\"},\"resourceId\":\"canvas\",\"ssextensions\":[],\"stencil\":{\"id\":\"BPMNDiagram\"},\"stencilset\":{\"namespace\":\"http://b3mn.org/stencilset/bpmn2.0#\",\"url\":\"../stencilsets/bpmn2.0/bpmn2.0.json\"}}}";
//		response.getWriter().print(aa);
		// TODO Auto-generated method stub
//		ProcessEngine processEngine=ProcessEngineManagement.getDefaultProcessEngine();
//		String dbDriver = "oracle.jdbc.driver.OracleDriver";
//		String dbUrl = "jdbc:oracle:thin:@172.29.165.250:1521:orcl";
//		String dbUserName = "idbase2";
//		String dbPwd = "idbase2";
//		Connection connection = null;
//		try {
//			Class.forName(dbDriver);
//			connection = DriverManager.getConnection(dbUrl, dbUserName, dbPwd);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		ExternalContent externalContent =new ExternalContent();
//		externalContent.setAuthenticatedUserId("1200119390");
//		externalContent.setConnection(connection);
//		processEngine.setExternalContent(externalContent);
//		
//		ModelService modelService = processEngine.getModelService();
		Definitions model = getDefinitions();
//		Definitions model1 = modelService.getProcessDefinition("process_testych:1:0ddfb246-4451-454f-b81b-14c4b38c3964").getDefinitions();
		
		BpmnJsonConverter converter = new BpmnJsonConverter();
		ObjectNode o = converter.convertToJson(model);
//		ObjectNode o2 = converter.convertToJson(model1);
		
		
		InputStream stencilsetStream = this.getClass().getClassLoader().getResourceAsStream("test.usertaskmodel.json");
		StringBuffer document = new StringBuffer();
		response.setContentType("application/x-json");   
		PrintWriter out = response.getWriter();
        try 
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stencilsetStream));
            String line = null;
            while ((line = reader.readLine()) != null)
            	document.append(line + " ");
            reader.close();
//            out.print(document.toString());
            out.print(o);
        }catch(Exception ex){
        	ex.printStackTrace();
        }finally{
        	out.flush();
        	out.close();
        }
	}
	public Definitions getDefinitions(){
		String processKey = "process_testych";
		ProcessDefinitionBehavior processDefinition = null;
		ResourceSet resourceSet = getResourceSet();
		InputStream input = this.getClass().getClassLoader().getResourceAsStream("process_testych.bpmn");
		String filePath = this.getClass().getClassLoader().getResource("com/founder/fix/fixflow/expand/config/fixflowfile.bpmn").toString();
		Resource ddddResource = null;
		if (!filePath.startsWith("jar")) {
			try {
				filePath = java.net.URLDecoder.decode(ReflectUtil.getResource("com/founder/fix/fixflow/expand/config/fixflowfile.bpmn").getFile(),
						"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				throw new FixFlowException("流程定义文件加载失败！", e);
			}
			ddddResource = resourceSet.createResource(URI.createFileURI(filePath));
		} else {
			ddddResource = resourceSet.createResource(URI.createURI(filePath));
		}
		try {
			ddddResource.load(input, null);
		} catch (UnsupportedEncodingException e) {
			throw new FixFlowException("定义文件加载失败!", e);
		} catch (IOException e) {
			throw new FixFlowException("定义文件加载失败!", e);
		}
		DefinitionsBehavior definitions = (DefinitionsBehavior) ddddResource.getContents().get(0).eContents().get(0);
		definitions.setProcessId("process_testych:1:0ddfb246-4451-454f-b81b-14c4b38c3964");
		return definitions;
	}
	private ResourceSet getResourceSet() {
		ResourceSet resourceSet = new ResourceSetImpl();
		(EPackage.Registry.INSTANCE).put("http://www.omg.org/spec/BPMN/20100524/MODEL", Bpmn2Package.eINSTANCE);
		(EPackage.Registry.INSTANCE).put("http://www.founderfix.com/fixflow", FixFlowPackage.eINSTANCE);
		(EPackage.Registry.INSTANCE).put("http://www.omg.org/spec/DD/20100524/DI", DiPackage.eINSTANCE);
		(EPackage.Registry.INSTANCE).put("http://www.omg.org/spec/DD/20100524/DC", DcPackage.eINSTANCE);
		(EPackage.Registry.INSTANCE).put("http://www.omg.org/spec/BPMN/20100524/DI", BpmnDiPackage.eINSTANCE);
		FixFlowPackage.eINSTANCE.eClass();
		FixFlowPackage xxxPackage = FixFlowPackage.eINSTANCE;
		EPackage.Registry.INSTANCE.put(xxxPackage.getNsURI(), xxxPackage);
		Bpmn2ResourceFactoryImpl ddd = new Bpmn2ResourceFactoryImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("fixflow", ddd);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("bpmn", ddd);
		resourceSet.getPackageRegistry().put(xxxPackage.getNsURI(), xxxPackage);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("bpmn", ddd);
		return resourceSet;
	}
	
	public static ByteArrayOutputStream InputStreamTOByte(InputStream in) throws IOException{  
		          
       ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
       byte[] data = new byte[BUFFER_SIZE];  
       int count = -1;  
       while((count = in.read(data,0,BUFFER_SIZE)) != -1)  
           outStream.write(data, 0, count);  
         
       data = null;  
       return outStream;  
    }  

}
