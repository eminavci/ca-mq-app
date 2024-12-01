import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Partner } from '../models/Partner';
import { environment } from '../../environments/environment.development';
import { RestResponse } from '../models/RestResponse';

@Injectable({
  providedIn: 'root'
})
export class PartnerService {

  constructor(private http: HttpClient) { }

  getAllPartners(): Observable<RestResponse> {
    return this.http.get<RestResponse>(environment.API_URL_PARTNER);
  }

  savePartner(obj: Partner): Observable<RestResponse> {
    return this.http.post<RestResponse>(environment.API_URL_PARTNER, obj);
  }

  deletePartner(obj: Partner): Observable<RestResponse> {
    return this.http.delete<RestResponse>(environment.API_URL_PARTNER + "?id=" + obj.id);
  }

}
