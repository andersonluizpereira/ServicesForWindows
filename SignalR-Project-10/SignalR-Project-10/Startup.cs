using System;
using System.Threading.Tasks;
using Microsoft.Owin;
using Owin;

[assembly: OwinStartup(typeof(SignalR_Project_10.Startup))]

namespace SignalR_Project_10
{
    public class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            app.MapSignalR<ConnectionSpy>("/spy");
            app.Use<SpyMiddleware>();
            // For more information on how to configure your application, visit http://go.microsoft.com/fwlink/?LinkID=316888
        }
    }
}
