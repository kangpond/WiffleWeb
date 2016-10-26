package gov.nia.nrs.sys.action;

import gov.nia.nrs.action.BaseAction;
import gov.nia.nrs.domain.Functions;
import gov.nia.nrs.ws.FunctionWebService;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@Namespace("/functions")
public class FunctionsAction extends BaseAction implements ModelDriven<Functions>, Preparable {

    private static final long serialVersionUID = 1L;

    @Resource FunctionWebService functionService;
    
    private Functions function;
    private List<Functions> functionList;

    public List<Functions> getFunctionList() {
        return functionList;
    }

    public void setFunctionList(List<Functions> functionList) {
        this.functionList = functionList;
    }

    @Override
    public Functions getModel() {
        if (function == null){
            function = new Functions();
        }
        return function;
    }


    @Action(value = "functionList", results = {@Result(name = "success", location = "function.functionList.tiles", type = "tiles")})
    @SkipValidation
    public String functionList() {
        functionList = functionService.getFunctionList(function);
        return SUCCESS;
    }

    @Action(value = "createFunc", results = {@Result(name = "success", location = "function.create.tiles", type = "tiles")})
    @SkipValidation
    public String createFunc() {
        return SUCCESS;
    }


    @Action(value = "updateFunc", results = {@Result(name = "success", location = "function.create.tiles", type = "tiles")})
    @SkipValidation
    public String updateFunc() {
        function = functionService.getFunction(function.getFunctionId());
        return SUCCESS;
    }


    @Action(value = "saveFunction", results = {@Result(name = "success", location = "functionList.action", type = "redirect"),
            @Result(name = "input", location = "function.create.tiles", type = "tiles")})
    @Validations(requiredStrings = {@RequiredStringValidator(type = ValidatorType.SIMPLE, trim = true, fieldName = "functionId", message = "請輸入功能代號!!"),
            @RequiredStringValidator(type = ValidatorType.SIMPLE, trim = true, fieldName = "functionName", message = "請輸入功能名稱!!"),
            @RequiredStringValidator(type = ValidatorType.SIMPLE, trim = true, fieldName = "isLeaf", message = "請輸入功能節點!!"),
            @RequiredStringValidator(type = ValidatorType.SIMPLE, trim = true, fieldName = "linkUrl", message = "請輸入功能連結!!")})
    public String saveFunction() {
        String result = "";
        if (functionService.saveFunction(function,getUserProfile().getUserId())) {
            result = SUCCESS;
        } else {
            result = INPUT;
        }
        return result;
    }

    @Override
    public void prepare() throws Exception {
        functionList = functionService.getUpperFunctionList();
    }

    @Action(value = "delete", results = {@Result(name = "success", location = "functionList.action", type = "redirect")})
    @SkipValidation
    public String delete() {
        boolean result = false;
        try {
        	functionService.deleteFunction(function.getFunctionId());
        	result = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
        		
        if (!result) {
            setMessage("功能表刪除發生錯誤!");
        }
        return SUCCESS;
    }

}
