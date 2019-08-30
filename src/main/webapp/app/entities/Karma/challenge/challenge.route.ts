import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { Challenge } from 'app/shared/model/Karma/challenge.model';
import { ChallengeService } from './challenge.service';
import { ChallengeComponent } from './challenge.component';
import { ChallengeDetailComponent } from './challenge-detail.component';
import { ChallengeUpdateComponent } from './challenge-update.component';
import { ChallengeDeletePopupComponent } from './challenge-delete-dialog.component';
import { IChallenge } from 'app/shared/model/Karma/challenge.model';

@Injectable({ providedIn: 'root' })
export class ChallengeResolve implements Resolve<IChallenge> {
  constructor(private service: ChallengeService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Challenge> {
    const id = route.params['id'] ? route.params['id'] : null;
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<Challenge>) => response.ok),
        map((challenge: HttpResponse<Challenge>) => challenge.body)
      );
    }
    return of(new Challenge());
  }
}

export const challengeRoute: Routes = [
  {
    path: 'challenge',
    component: ChallengeComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: ['ROLE_USER'],
      defaultSort: 'id,asc',
      pageTitle: 'Challenges'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'challenge/:id/view',
    component: ChallengeDetailComponent,
    resolve: {
      challenge: ChallengeResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Challenges'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'challenge/new',
    component: ChallengeUpdateComponent,
    resolve: {
      challenge: ChallengeResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Challenges'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'challenge/:id/edit',
    component: ChallengeUpdateComponent,
    resolve: {
      challenge: ChallengeResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Challenges'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const challengePopupRoute: Routes = [
  {
    path: 'challenge/:id/delete',
    component: ChallengeDeletePopupComponent,
    resolve: {
      challenge: ChallengeResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Challenges'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
