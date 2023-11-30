const express=require("express");
var myrouter=express.Router();
//connection is same as mysqlconnection in dbconnet.js
var connection=require("../db/dbconnect")

//to display all products in tabular form
myrouter.get("/employee",function(req,resp){
    connection.query("select * from emp",(err,data,fileds)=>{
        if(err){
            resp.status(500).send("no data found");
        }
        else{
            resp.send(data);
        }
    })

});

myrouter.post("/employee/employee/:eid",function(req,resp){
    connection.query("insert into emp values(?,?,?,?)",[req.params.eid,req.body.ename,req.body.deptid,req.body.sal],(err,result)=>{
        if(err){
            resp.status(500).send("no data added");
        }else{
            resp.send("added successfully");
        }

    })
});

myrouter.delete("/employee/:eid",function(req,resp){
    connection.query("delete from emp where empid =?)",[req.params.eid],(err,result)=>{
        if(err){
            resp.status(500).send("no data added");
        }else{
            console.log(result);
            resp.send("deleted successfully");
        }

    })
});

module.exports=myrouter;