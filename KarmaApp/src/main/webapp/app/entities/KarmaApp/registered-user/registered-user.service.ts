import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRegisteredUser } from 'app/shared/model/KarmaApp/registered-user.model';

type EntityResponseType = HttpResponse<IRegisteredUser>;
type EntityArrayResponseType = HttpResponse<IRegisteredUser[]>;

@Injectable({ providedIn: 'root' })
export class RegisteredUserService {
  public resourceUrl = SERVER_API_URL + 'api/registered-users';

  constructor(private http: HttpClient) {}

  create(registeredUser: IRegisteredUser): Observable<EntityResponseType> {
    return this.http.post<IRegisteredUser>(this.resourceUrl, registeredUser, { observe: 'response' });
  }

  update(registeredUser: IRegisteredUser): Observable<EntityResponseType> {
    return this.http.put<IRegisteredUser>(this.resourceUrl, registeredUser, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IRegisteredUser>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IRegisteredUser[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
