using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNet.SignalR;


namespace SignalR_Project_01
{
   public class MyTrackConnection : PersistentConnection
    {
        /// <summary>
        /// 
        /// </summary>
        /// <param name="request"></param>
        /// <param name="connectionId"></param>
        /// <param name="data"></param>
        /// <returns>
        /// Classe criado para o projeto 05
        /// 
        /// </returns>
        protected override Task OnReceived(IRequest request, string connectionId, string data)
        {
            return Connection.Broadcast(data);
        }


    }
}
