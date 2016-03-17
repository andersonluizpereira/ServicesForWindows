using System;
using System.Threading.Tasks;
using Microsoft.Owin;
using Owin;

[assembly: OwinStartup(typeof(SignalR_Project_01.Startup))]

namespace SignalR_Project_01
{
    public class Startup
    {
        public void Configuration(IAppBuilder app)
        {
             app.MapSignalR(); //Sem conexão persistente, trabalha com HUB de conexões

            /////////caso queira inserir um novo hub, dentro do app.MapSignalR();
            /// insira  app.MapSignalR("/myconection" ,new HubConfiguration());, pois o mapeamento padrão é /SignalR
            
            //app.MapSignalR<MyTrackConnection>("/myconn"); //projeto 05, aqui é configurado para o persistence connection.


        }
    }
}
