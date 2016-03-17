using Microsoft.AspNet.SignalR;
using Microsoft.AspNet.SignalR.Hubs;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SignalR_Project_7
{
  public class ChatHub:Hub
    {

        public void sendMessageToAll(string message) {

            Clients.All.sendMessageToAll(message);
            Clients.Caller.alertCaller("You message was sent.");

        }

    }
}
