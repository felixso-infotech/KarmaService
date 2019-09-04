import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IChallenge } from 'app/shared/model/Karma/challenge.model';

type EntityResponseType = HttpResponse<IChallenge>;
type EntityArrayResponseType = HttpResponse<IChallenge[]>;

@Injectable({ providedIn: 'root' })
export class ChallengeService {
  public resourceUrl = SERVER_API_URL + 'api/challenges';

  constructor(private http: HttpClient) {}

  create(challenge: IChallenge): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(challenge);
    return this.http
      .post<IChallenge>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(challenge: IChallenge): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(challenge);
    return this.http
      .put<IChallenge>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IChallenge>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IChallenge[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(challenge: IChallenge): IChallenge {
    const copy: IChallenge = Object.assign({}, challenge, {
      createdDate: challenge.createdDate != null && challenge.createdDate.isValid() ? challenge.createdDate.toJSON() : null
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
      res.body.forEach((challenge: IChallenge) => {
        challenge.createdDate = challenge.createdDate != null ? moment(challenge.createdDate) : null;
      });
    }
    return res;
  }
}
