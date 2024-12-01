import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RestResponse } from '../models/RestResponse';
import { environment } from '../../environments/environment.development';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MQService {

  constructor(private http: HttpClient) { }

  getAllMessages(): Observable<RestResponse> {
    return this.http.get<RestResponse>(environment.API_URL_QM);
  }

}
