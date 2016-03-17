using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.SessionState;
using Microsoft.AspNet.SignalR;
namespace SignalR_Project_10
{
    public class Global : System.Web.HttpApplication
    {
        private static IPersistentConnectionContext connSpy = GlobalHost.ConnectionManager.GetConnectionContext<ConnectionSpy>();

        protected void Application_Start(object sender, EventArgs e)
        {

        }

        protected void Session_Start(object sender, EventArgs e)
        {

        }

        protected void Application_BeginRequest(object sender, EventArgs e)
        {
            var context = ((HttpApplication)sender).Context;
            var message = string.Format("{0}: Requested '{1}' from IP {2} using {3}",DateTime.Now.ToShortTimeString(),context.Request.Url.ToString(),context.Request.UserHostAddress,context.Request.Browser.Type);

            connSpy.Connection.Broadcast(message);
        }

        protected void Application_AuthenticateRequest(object sender, EventArgs e)
        {

        }

        protected void Application_Error(object sender, EventArgs e)
        {

        }

        protected void Session_End(object sender, EventArgs e)
        {

        }

        protected void Application_End(object sender, EventArgs e)
        {

        }
    }
}