using System;
using System.Collections.Generic;
using System.Collections.Concurrent;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using Microsoft.AspNet.SignalR;
using Microsoft.AspNet.SignalR.Hubs;

namespace SignalR_Project_01.Projeto06
{

    /// <summary>
    /// Caso queira modificar o nome do hub
    /// insira uma anotação [HubName("MyHub")]
    /// em cima da classe
    /// </summary>
   public class ChatHub : Hub
    {

        private static int _userCount = 0;

        private static ConcurrentDictionary<string, UserData> _users = new ConcurrentDictionary<string, UserData>();

        public override Task OnConnected()
        {
            Interlocked.Increment(ref _userCount);
            var user = new UserData()
            {

                Active = true,
                Name = Context.QueryString["myQueryString"],
                ConnectedAt = DateTime.Now
            };
            _users[Context.ConnectionId] = user;

            //return Clients.All.showAlertConnected();
            return base.OnConnected();
        }

        public override Task OnDisconnected(bool stopCalled)
        {
            Interlocked.Decrement(ref _userCount);

            _users[Context.ConnectionId] = null;
            //return Clients.All.showAlertDisconnected();
            return base.OnDisconnected(stopCalled);
        }


        public void Connected(string text) {
            Clients.All.connectedMessage(text);

        }

        public void MySend(MyMessage msg) {
            if (String.IsNullOrEmpty(msg.Client))
            {

                //Clients.All.broadcastMessage(msg.Name, msg.Message, msg.Time);

                Clients.Others.broadcastMessage(msg.Name, msg.Message, msg.Time);
                Clients.Caller.sentMessage("Your Message was sent.");
            }

            else
            {
                Clients.Client(msg.Client).clientMessage(msg.Name,msg.Message,msg.Time);
                Clients.Caller.sentMessage("Your message was sent.");

            }

        }
        public void AlertAll(string name) {
            Clients.AllExcept(Context.ConnectionId).showAlertAll(name);
        }

        public void JoinGroup(string name) {
            Groups.Add(Context.ConnectionId, "VIP");
            Clients.Group("VIP").groupMessage(name + "Join in VIP group.");
        }

        public void LeaveGroup(string name)
        {
            Groups.Remove(Context.ConnectionId, "VIP");
            Clients.Group("VIP").groupMessage(name + "leave in VIP group.");
        }

        public void infoContext() {
            Clients.Caller.showAlertYou(Context.ConnectionId + "\n" + Context.Request.Headers + "\n" + Context.User +"\n"+ Context.RequestCookies + "\n"+ Context.QueryString["myQueryString"]);
        }

        public void infoServer() {
            Clients.Caller.showAlertInfoServer("Info saved in the server:\n Quantity of users :"+ _userCount +"\n Your name: "+_users[Context.ConnectionId].Name.ToString() + "\n Your ConnectedAt: " + _users[Context.ConnectionId].ConnectedAt.ToString() + "\n Active: " + _users[Context.ConnectionId].Active.ToString());
        }
        public class MyMessage{
            public string Name { get; set; }
            public string Message { get; set; }
            public string Time { get; set; }
            public string Client { get; set; }
        }

        public class UserData {
            public bool Active { get; set; }
            public string Name { get; set; }
            public DateTime ConnectedAt { get; set; }

        }

    }
}
