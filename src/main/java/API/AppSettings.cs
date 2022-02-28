using System.Text;

namespace ExPay.Api
{
    public static class AppSettings
    {
        public const string ServiceUrl = "https://sandbox-api.express-pay.by/v1/";
        public const string Token = "a75b74cbcfe446509e8ee874f421bd64"; // API-ключ
        public static readonly Encoding DefaultEncoding = Encoding.UTF8;
        public static int ServiceId = 2;
    }
}
