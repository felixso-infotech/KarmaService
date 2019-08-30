import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { CommittedActivity } from 'app/shared/model/Karma/committed-activity.model';
import { CommittedActivityService } from './committed-activity.service';
import { CommittedActivityComponent } from './committed-activity.component';
import { CommittedActivityDetailComponent } from './committed-activity-detail.component';
import { CommittedActivityUpdateComponent } from './committed-activity-update.component';
import { CommittedActivityDeletePopupComponent } from './committed-activity-delete-dialog.component';
import { ICommittedActivity } from 'app/shared/model/Karma/committed-activity.model';

@Injectable({ providedIn: 'root' })
export class CommittedActivityResolve implements Resolve<ICommittedActivity> {
  constructor(private service: CommittedActivityService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<CommittedActivity> {
    const id = route.params['id'] ? route.params['id'] : null;
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<CommittedActivity>) => response.ok),
        map((committedActivity: HttpResponse<CommittedActivity>) => committedActivity.body)
      );
    }
    return of(new CommittedActivity());
  }
}

export const committedActivityRoute: Routes = [
  {
    path: 'committed-activity',
    component: CommittedActivityComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: ['ROLE_USER'],
      defaultSort: 'id,asc',
      pageTitle: 'CommittedActivities'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'committed-activity/:id/view',
    component: CommittedActivityDetailComponent,
    resolve: {
      committedActivity: CommittedActivityResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CommittedActivities'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'committed-activity/new',
    component: CommittedActivityUpdateComponent,
    resolve: {
      committedActivity: CommittedActivityResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CommittedActivities'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'committed-activity/:id/edit',
    component: CommittedActivityUpdateComponent,
    resolve: {
      committedActivity: CommittedActivityResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CommittedActivities'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const committedActivityPopupRoute: Routes = [
  {
    path: 'committed-activity/:id/delete',
    component: CommittedActivityDeletePopupComponent,
    resolve: {
      committedActivity: CommittedActivityResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CommittedActivities'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
