import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {PerunInstance} from "./PerunInstance";

@Injectable({
  providedIn: 'root'
})
export class InstancesService {

  endpoint = "http://localhost:8080";

  httpOptions = {
    headers : new HttpHeaders({
      'Content-Type' : 'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  getInstances() : Observable<PerunInstance[]> {
    return this.http.get<PerunInstance[]>(this.endpoint + '/instances');
  }

  addInstance(instance : PerunInstance) : Observable<PerunInstance> {
    return this.http.post<PerunInstance>(this.endpoint + '/instances', instance);
  }
}
