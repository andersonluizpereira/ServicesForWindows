using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Owin;
using Microsoft.Owin;

[assembly:OwinStartup(typeof(SignalR_Project_15.Startup))]
namespace SignalR_Project_15
{
  public class Startup
    {
        public void Configuration(IAppBuilder app) {
            app.MapSignalR();
        }
        
    }
}
