    using System;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.Net;

namespace ExPay.Api
{
    public static class InvoiceExample
    {
        private const string NumberInvoice = "123456";
        private const string CardNumberInvoice = "1674";
        private const string SiteUrl = "https://example.com/";

        public static void AddInvoice()
        {
            var requestParams = new Dictionary<string, string>
            {
                {"Token", AppSettings.Token},
                {"AccountNo", "123456"},
                {"Amount", "10"},
                {"Currency", "933"},
                {"Expiration", "20160505"},
                {"Info", "info"},
                {"Surname", "Ivanov"},
                {"FirstName", "Ivan"},
                {"Patronymic", "Ivanovich"},
                {"City", "Minsk"},
                {"Street", "Frunze"},
                {"House", "20"},
                {"Building", "2"},
                {"Apartment", "10"},
                {"IsNameEditable", "0"},
                {"IsAddressEditable", "0"},
                {"IsAmountEditable", "0"},
                {"EmailNotification", "ivanov@gmail.com"},
            };
            var signature = SignatureHelper.Compute(requestParams, string.Empty, "add-invoice");
            using (var client = new WebClient())
            {
                var url = AppSettings.ServiceUrl + "invoices?token=" + AppSettings.Token + "&signature=" + signature;
                var response = client.UploadValues(url, new NameValueCollection
                {
                    {"AccountNo", "123456"},
                    {"Amount", "10"},
                    {"Currency", "933"},
                    {"Expiration", "20160505"},
                    {"Info", "info"},
                    {"Surname", "Ivanov"},
                    {"FirstName", "Ivan"},
                    {"Patronymic", "Ivanovich"},
                    {"City", "Minsk"},
                    {"Street", "Frunze"},
                    {"House", "20"},
                    {"Building", "2"},
                    {"Apartment", "10"},
                    {"IsNameEditable", "0"},
                    {"IsAddressEditable", "0"},
                    {"IsAmountEditable", "0"},
                    {"EmailNotification", "ivanov@gmail.com"},
                });
                var data = AppSettings.DefaultEncoding.GetString(response);
                Console.WriteLine(data);
            }
        }

        public static void GetDetailsInvoice()
        {
            var requestParams = new Dictionary<string, string>
            {
                {"Token", AppSettings.Token},
                {"Id", NumberInvoice}
            };

            var signature = SignatureHelper.Compute(requestParams, string.Empty, "get-details-invoice");

            using (var client = new WebClient())
            {
                client.Encoding = AppSettings.DefaultEncoding;
                var data =
                    client.DownloadString(AppSettings.ServiceUrl + "invoices/" + NumberInvoice + "?token=" + AppSettings.Token + "&signature=" +
                                          signature);
                Console.WriteLine(data);
            }
        }

        public static void CancelInvoice()
        {
            var requestParams = new Dictionary<string, string>
            {
                {"Token", AppSettings.Token},
                {"Id", NumberInvoice}
            };

            var signature = SignatureHelper.Compute(requestParams, string.Empty, "cancel-invoice");
            var url = AppSettings.ServiceUrl + "invoices/" + NumberInvoice + "?token=" + AppSettings.Token + "&signature=" + signature;
            using (var client = new WebClient())
            {
                client.Encoding = AppSettings.DefaultEncoding;
                var data = client.UploadString(url, "DELETE", string.Empty);
                Console.WriteLine(data);
            }
        }

        public static void GetStatusInvoice()
        {
            var requestParams = new Dictionary<string, string>
            {
                {"Token", AppSettings.Token},
                {"InvoiceId", NumberInvoice}
            };

            var signature = SignatureHelper.Compute(requestParams, string.Empty, "status-invoice");
            var url = AppSettings.ServiceUrl + "invoices/" + NumberInvoice + "/status?token=" + AppSettings.Token + "&signature=" + signature;
            using (var client = new WebClient())
            {
                client.Encoding = AppSettings.DefaultEncoding;
                var data = client.DownloadString(url);
                Console.WriteLine(data);
            }
        }

        public static void GetListInvoices()
        {
            var requestParams = new Dictionary<string, string>
            {
                {"Token", AppSettings.Token},

                //Параметры фильтра являются опциональными, по умолчанию возврщает значения за последние 30 дней
                {"AccountNo", NumberInvoice},
                {"From", "20000101" },
                {"To", "21000101" },
                {"Status", "1" }
            };

            var signature = SignatureHelper.Compute(requestParams, string.Empty, "get-list-invoices");

            var url = AppSettings.ServiceUrl + "invoices?token=" + AppSettings.Token + "&signature=" + signature + "&From=20000101&To=21000101&AccountNo=" + NumberInvoice + "&Status=1";
            using (var client = new WebClient())
            {
                client.Encoding = AppSettings.DefaultEncoding;
                var data = client.DownloadString(url);

                Console.WriteLine(data);
            }
        }

    }
}