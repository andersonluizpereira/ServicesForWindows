using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Microsoft.AspNet.SignalR;
using Microsoft.AspNet.SignalR.Hubs;
using Newtonsoft.Json;

namespace SignalR_Project_7
{
    public class ShapeHub : Hub
    {

        public void UpdateModel(ShapeModel clientModel) {
            Clients.AllExcept(Context.ConnectionId).updateShape(clientModel);
        }


        public class ShapeModel
        {  [JsonProperty("left")]
            public double Left { get; set; }

            [JsonProperty("top")]
            public double Top { get; set; }
        }


    }
}