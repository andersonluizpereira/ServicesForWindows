using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNet.SignalR;
using Microsoft.Owin.Hosting;
using Microsoft.Owin;
using Microsoft.Owin.Cors;
using Owin;

[assembly: OwinStartup(typeof(SignalR_Project_13.Startup))]
namespace SignalR_Project_13
{
    class Program
    {
        static void Main(string[] args)
        {
            string url = "http://localhost:8080";
            using (WebApp.Start(url)) {
                Console.WriteLine("Server running on {0}", url);
                Console.ReadLine();
            }
        }


        public class MyHub : Hub {

            public void Send(string name, string message)
            {
                Clients.All.addMessage(name,message);
            }
        }

    }

    class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            app.UseCors(CorsOptions.AllowAll);
            app.MapSignalR();
        }
    }
}
