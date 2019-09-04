import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ICompletedChallenge } from 'app/shared/model/Karma/completed-challenge.model';

type EntityResponseType = HttpResponse<ICompletedChallenge>;
type EntityArrayResponseType = HttpResponse<ICompletedChallenge[]>;

@Injectable({ providedIn: 'root' })
export class CompletedChallengeService {
  public resourceUrl = SERVER_API_URL + 'api/completed-challenges';

  constructor(private http: HttpClient) {}

  create(completedChallenge: ICompletedChallenge): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(completedChallenge);
    return this.http
      .post<ICompletedChallenge>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(completedChallenge: ICompletedChallenge): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(completedChallenge);
    return this.http
      .put<ICompletedChallenge>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<ICompletedChallenge>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<ICompletedChallenge[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(completedChallenge: ICompletedChallenge): ICompletedChallenge {
    const copy: ICompletedChallenge = Object.assign({}, completedChallenge, {
      createdDate:
        completedChallenge.createdDate != null && completedChallenge.createdDate.isValid() ? completedChallenge.createdDate.toJSON() : null
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.createdDate = res.body.createdDate != null ? moment(res.body.createdDate) : null;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((completedChallenge: ICompletedChallenge) => {
        completedChallenge.createdDate = completedChallenge.createdDate != null ? moment(completedChallenge.createdDate) : null;
      });
    }
    return res;
  }
}
