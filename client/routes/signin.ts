/*
*
*GET Sign up page
* 
*/
import express = require('express');

export function signin(req: express.Request, res: express.Response) {

    res.render('signin', { title: "Logon Page" })
}

