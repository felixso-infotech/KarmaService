import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ICommittedActivity } from 'app/shared/model/Karma/committed-activity.model';

type EntityResponseType = HttpResponse<ICommittedActivity>;
type EntityArrayResponseType = HttpResponse<ICommittedActivity[]>;

@Injectable({ providedIn: 'root' })
export class CommittedActivityService {
  public resourceUrl = SERVER_API_URL + 'api/committed-activities';

  constructor(private http: HttpClient) {}

  create(committedActivity: ICommittedActivity): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(committedActivity);
    return this.http
      .post<ICommittedActivity>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(committedActivity: ICommittedActivity): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(committedActivity);
    return this.http
      .put<ICommittedActivity>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<ICommittedActivity>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<ICommittedActivity[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(committedActivity: ICommittedActivity): ICommittedActivity {
    const copy: ICommittedActivity = Object.assign({}, committedActivity, {
      createdDateAndTime:
        committedActivity.createdDateAndTime != null && committedActivity.createdDateAndTime.isValid()
          ? committedActivity.createdDateAndTime.toJSON()
          : null
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.createdDateAndTime = res.body.createdDateAndTime != null ? moment(res.body.createdDateAndTime) : null;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((committedActivity: ICommittedActivity) => {
        committedActivity.createdDateAndTime =
          committedActivity.createdDateAndTime != null ? moment(committedActivity.createdDateAndTime) : null;
      });
    }
    return res;
  }
}
