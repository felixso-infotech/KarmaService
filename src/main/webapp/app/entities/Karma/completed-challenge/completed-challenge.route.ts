import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { CompletedChallenge } from 'app/shared/model/Karma/completed-challenge.model';
import { CompletedChallengeService } from './completed-challenge.service';
import { CompletedChallengeComponent } from './completed-challenge.component';
import { CompletedChallengeDetailComponent } from './completed-challenge-detail.component';
import { CompletedChallengeUpdateComponent } from './completed-challenge-update.component';
import { CompletedChallengeDeletePopupComponent } from './completed-challenge-delete-dialog.component';
import { ICompletedChallenge } from 'app/shared/model/Karma/completed-challenge.model';

@Injectable({ providedIn: 'root' })
export class CompletedChallengeResolve implements Resolve<ICompletedChallenge> {
  constructor(private service: CompletedChallengeService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<CompletedChallenge> {
    const id = route.params['id'] ? route.params['id'] : null;
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<CompletedChallenge>) => response.ok),
        map((completedChallenge: HttpResponse<CompletedChallenge>) => completedChallenge.body)
      );
    }
    return of(new CompletedChallenge());
  }
}

export const completedChallengeRoute: Routes = [
  {
    path: 'completed-challenge',
    component: CompletedChallengeComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: ['ROLE_USER'],
      defaultSort: 'id,asc',
      pageTitle: 'CompletedChallenges'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'completed-challenge/:id/view',
    component: CompletedChallengeDetailComponent,
    resolve: {
      completedChallenge: CompletedChallengeResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CompletedChallenges'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'completed-challenge/new',
    component: CompletedChallengeUpdateComponent,
    resolve: {
      completedChallenge: CompletedChallengeResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CompletedChallenges'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'completed-challenge/:id/edit',
    component: CompletedChallengeUpdateComponent,
    resolve: {
      completedChallenge: CompletedChallengeResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CompletedChallenges'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const completedChallengePopupRoute: Routes = [
  {
    path: 'completed-challenge/:id/delete',
    component: CompletedChallengeDeletePopupComponent,
    resolve: {
      completedChallenge: CompletedChallengeResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CompletedChallenges'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
