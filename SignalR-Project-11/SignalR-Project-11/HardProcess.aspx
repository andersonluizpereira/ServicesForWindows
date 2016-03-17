<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="HardProcess.aspx.cs" Inherits="SignalR_Project_11.HardProcess" %>
<%@ Import Namespace="System.Diagnostics" %>
<%@ Import Namespace="System.Threading" %>
<%@ Import Namespace="Microsoft.AspNet.SignalR" %>
<%@ Import Namespace="SignalR_Project_11" %>

<%
    Response.Expires=1;
    var connectionId = Request["connId"];
    var hub = GlobalHost.ConnectionManager.GetHubContext<ProgressBarHub>();

    Stopwatch stopwatch = Stopwatch.StartNew();

    for (int i = 0; i < 100; i++)
    {
        hub.Clients.Client(connectionId).update(i);
        Thread.Sleep(150);

    }

%>

<p>Hello Word !!!</p>

<p>total time  <%:stopwatch.ElapsedMilliseconds /1000 %> seconds.</p>
