import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { User } from '../_models/index';

@Injectable()
export class UserService {
    constructor(private http: Http) { }

    getAll() {
           return Observable.fromPromise(new Promise((resolve, reject) => {
        let xhr = new XMLHttpRequest()
        xhr.open("GET",'http://localhost:8080/RestAPI/api/Movies', true)
        xhr.setRequestHeader("content-type","application/x-www-form-urlencoded" )
        xhr.onreadystatechange = function(){
            if(xhr.readyState == 4 && xhr.status ==200)
                 resolve(JSON.parse(xhr.response))
            else    
                 reject(xhr.response)
        }
      
       
    }))

    }

    getById(id: number) {
        return this.http.get('/api/users/' + id, this.jwt()).map((response: Response) => response.json());
    }

    create(user: User) {
        return this.http.post('/api/users', user, this.jwt()).map((response: Response) => response.json());
    }

    update(user: User) {
        return this.http.put('/api/users/' + user.id, user, this.jwt()).map((response: Response) => response.json());
    }

    delete(id: number) {
        return this.http.delete('/api/users/' + id, this.jwt()).map((response: Response) => response.json());
    }

    // private helper methods

    private jwt() {
        // create authorization header with jwt token
        let currentUser = JSON.parse(localStorage.getItem('currentUser'));
        if (currentUser && currentUser.token) {
            let headers = new Headers({ 'Authorization': 'Bearer ' + currentUser.token });
            return new RequestOptions({ headers: headers });
        }
    }
}