using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNet.SignalR;
using Microsoft.Owin;
namespace SignalR_Project_10
{
    public class SpyMiddleware : OwinMiddleware
    {
        private static IPersistentConnectionContext connSpy = GlobalHost.ConnectionManager.GetConnectionContext<ConnectionSpy>();

        public SpyMiddleware(OwinMiddleware next) : base(next) { }

        public override Task Invoke(IOwinContext context)
        {
            var message = string.Format(
                "{0}: Request '{1}' from IP '{2} using {3}'",
                DateTime.Now.ToShortTimeString(),
                context.Request.Uri.ToString(),
                context.Request.Host,
                context.Request.Headers["USER-AGENT"]
                );

            return Next.Invoke(context).ContinueWith(c => connSpy.Connection.Broadcast(message));
        }

    }
}
