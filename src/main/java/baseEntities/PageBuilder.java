package baseEntities;


import pages.*;
import static constant.endpoints.EndPointsUrl.*;


public class PageBuilder {

    public static LoginPage buildLoginPage() {
        return new LoginPage("/");
    }
    public static HomePage buildHomePage() {
        return new HomePage("/");
    }
    public static InvoiceAddPage buildInvoiceAddPage() {
        return new InvoiceAddPage(ADD_INVOICE_PAGE);
    }
    public static InvoicesImportPage buildInvoicesImportPage() {
        return new InvoicesImportPage(INVOICES_IMPORT_PAGE);
    }
    public static InvoicesPage buildInvoicesPage() {
        return new InvoicesPage(INVOICES_PAGE);
    }
    public static PersonalDataPage buildPersonalDataPage() {
        return new PersonalDataPage(PERSONAL_DATA_PAGE);
    }
    public static ServicesPage buildServicesPage() {
        return new ServicesPage(SERVICES_PAGE);
    }

}
