using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Linq;
using System.ServiceProcess;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNet.SignalR;
using Microsoft.Owin;
using Owin;
using Microsoft.Owin.Cors;
using Microsoft.Owin.Hosting;

[assembly: OwinStartup(typeof(SignalR_Project_14.Startup))]
namespace SignalR_Project_14
{
    public partial class Service1 : ServiceBase
    {
        public Service1()
        {
            InitializeComponent();
        }

        protected override void OnStart(string[] args)
        {
            if (!System.Diagnostics.EventLog.SourceExists("SignalRChat"))
            {
                System.Diagnostics.EventLog.CreateEventSource("SignalRChat","Application");

            }
                eventLog1.Source = "SignalRChat";
                eventLog1.Log ="Application";
                eventLog1.WriteEntry("In OnStart");
                string url = "http://localhost:8080";
                WebApp.Start(url);
            
        }

        protected override void OnStop()
        {
            eventLog1.WriteEntry("In OnStop");
        }
    }

    class Startup
    {
        public void Configuration(IAppBuilder app) {
            app.UseCors(CorsOptions.AllowAll);
            app.MapSignalR();
        }

    }

    public class MyHub : Hub {
        public void Send(string name, string message) {
            Clients.All.addMessage(name, message);
        }

    }

}
