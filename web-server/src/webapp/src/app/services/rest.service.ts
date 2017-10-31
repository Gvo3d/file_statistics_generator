import {Http, Response, Headers, RequestOptions} from '@angular/http';
import {HttpModule} from '@angular/http';
import {Inject, OnInit} from '@angular/core';
import {Component, Injectable} from '@angular/core';
import {DatePipe} from '@angular/common';
import {Observable} from "rxjs/Observable";
import {Constants} from "../constants";

@Injectable()
export class RestTemplate implements OnInit {
    private baseUrl: string;
    private headers: Headers = new Headers();

    constructor(@Inject(Http) private http: Http) {
        this.baseUrl = Constants.HOME_URL;
    }

    ngOnInit(): void {
        this.headers.append('Content-Type', 'application/json');
        this.headers.append("Accept", 'application/json');
    }

    public doGet(url: string) {
      console.log('LAUNCHING:'+url);
        return this.http.get(this.getUrl(url), {headers: this.headers});
    }

    public doPost(url: string, dataToSend: Object): Observable<Response> {
        return this.http.post(this.getUrl(url), dataToSend, {headers: this.headers});
    }

    public doDelete(url: string): Observable<Response> {
        return this.http.delete(this.getUrl(url), {headers: this.headers});
    }

    private getUrl(url: string): string {
        return this.baseUrl + url;
    }

}
