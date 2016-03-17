using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNet.SignalR;
using System.Threading.Tasks;
namespace SignalR_Project_03
{
  public class MyConnection : PersistentConnection
    {
        protected override Task OnReceived(IRequest request, string connectionId, string data)
        {
            int i = 0;

            if ((i=data.IndexOf(":"))>-1)
            {
                var groupName = data.Substring(0, i);
                var messageOrcommand = data.Substring(i + 1);
///group name: command or message
                switch (messageOrcommand)
                {
                    case "join":
                        Groups.Add(connectionId, groupName);
                        Groups.Send(groupName, connectionId +"Join group "+groupName);
                        break;

                    case "leave":
                        Groups.Remove(connectionId, groupName);
                        Groups.Send(groupName, connectionId + "leave the group " + groupName);
                        break;

                    default:
                        Groups.Send(groupName, messageOrcommand + "(" + groupName+")");
                        break;
                }

                
            }
            else
            {
                Connection.Broadcast(data);
            }
            return base.OnReceived(request, connectionId, data);
        }
    }
}
