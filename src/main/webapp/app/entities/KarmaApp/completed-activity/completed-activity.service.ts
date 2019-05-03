import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ICompletedActivity } from 'app/shared/model/KarmaApp/completed-activity.model';

type EntityResponseType = HttpResponse<ICompletedActivity>;
type EntityArrayResponseType = HttpResponse<ICompletedActivity[]>;

@Injectable({ providedIn: 'root' })
export class CompletedActivityService {
  public resourceUrl = SERVER_API_URL + 'api/completed-activities';

  constructor(private http: HttpClient) {}

  create(completedActivity: ICompletedActivity): Observable<EntityResponseType> {
    return this.http.post<ICompletedActivity>(this.resourceUrl, completedActivity, { observe: 'response' });
  }

  update(completedActivity: ICompletedActivity): Observable<EntityResponseType> {
    return this.http.put<ICompletedActivity>(this.resourceUrl, completedActivity, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<ICompletedActivity>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ICompletedActivity[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
