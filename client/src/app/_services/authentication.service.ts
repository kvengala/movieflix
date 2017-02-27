import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { User } from '../_models/index';
import 'rxjs/add/operator/map'

@Injectable()
export class AuthenticationService {
    constructor(private http: Http) { }

    login(username: string, password: string) {
        return Observable.fromPromise(new Promise((resolve, reject) => {
        let xhr = new XMLHttpRequest()
        xhr.open("POST",'http://localhost:8080/RestAPI/api/User', true)
        xhr.setRequestHeader("content-type","application/x-www-form-urlencoded" )
        xhr.onreadystatechange = function(){
            if(xhr.readyState == 4 && xhr.status ==200)
                 resolve(JSON.parse(xhr.response))
            else    
                 reject(xhr.response)
        }
       let data = "username="+username+"&password="+password
        xhr.send(data)
         //console.log( JSON.stringify({ username: username, password: password }))
        
    }))
    .map((response: Response) => {
                let user = response.json();
                if (user && user.token) {
                    
                    localStorage.setItem('currentUser', JSON.stringify(user));
                }
            });    
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }
}