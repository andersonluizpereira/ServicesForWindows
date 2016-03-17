using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNet.SignalR;
using System.Threading.Tasks;
using Newtonsoft.Json;
namespace SignalR_Project_04
{
  public class Myconnection :PersistentConnection
    {
        protected override Task OnReceived(IRequest request, string connectionId, string data)
        {
            var message = JsonConvert.DeserializeObject<dynamic>(data);
            string strOut = "";


            if (message.Type ==1)
            {
                strOut = "Message from " + message.From + ":" + message.Text;
            }

            if (!string.IsNullOrEmpty(strOut))
            {
                Connection.Broadcast(data);
            }
            return base.OnReceived(request,connectionId,data);   
        }
    }
}
