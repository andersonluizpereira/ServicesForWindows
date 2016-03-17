using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNet.SignalR;
using Microsoft.AspNet.SignalR.Hubs;

namespace SignalR_Project8
{
   public class myServer:Hub
    {
        public void AlertAll(string message)
        {
            Clients.All.clientAlertAll(message);

        }
        
    }
}
