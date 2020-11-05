package step_definitions.applications.develop.initialSteps;

import com.webexuis.v1._generalApp.Pages;
import com.webexuis.v1.developWebex.DevelopWebexPages;
import step_definitions.applications.admin.initialSteps.AdminAuthentication;
import step_definitions.initalStep.BaseStep;
import utilities.exeptions.NullAppException;
import utilities.exeptions.NullParamException;
import utilities.exeptions.NullUserNameException;

public class DevelopBaseSteps extends BaseStep {

    protected DevelopWebexPages developWebexPages;

    public DevelopBaseSteps() throws NullAppException, NullUserNameException, NullParamException {
        authentication = new DevelopAuthentication(paramControl);
        developWebexPages = pages.getDevelopWebexPages();
    }
}
