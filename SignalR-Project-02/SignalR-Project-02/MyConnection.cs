using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Microsoft.AspNet.SignalR;
using System.Threading.Tasks;
using System.Threading;

namespace SignalR_Project_02
{
    public class MyConnection: PersistentConnection
    {
        protected override Task OnReceived(IRequest request, string connectionId, string data)
        {
            return Connection.Broadcast(data);    
        }
        /// <summary>
        /// New code below
        /// </summary>
        private static int QtyConnections = 0;

        protected override Task OnConnected(IRequest request, string connectionId)
        {
            Interlocked.Increment(ref QtyConnections);
            Connection.Broadcast("Visitors :"+QtyConnections);

            Connection.Send(connectionId,"Welcome "+connectionId);
            return base.OnConnected(request, connectionId);
        }

        protected override Task OnDisconnected(IRequest request, string connectionId, bool stopCalled)
        {
            Interlocked.Decrement(ref QtyConnections);
            Connection.Broadcast("Visitors :" + QtyConnections);
            return base.OnDisconnected(request, connectionId, stopCalled);
        }
    }
}