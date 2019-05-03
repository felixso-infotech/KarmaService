import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { CompletedActivity } from 'app/shared/model/KarmaApp/completed-activity.model';
import { CompletedActivityService } from './completed-activity.service';
import { CompletedActivityComponent } from './completed-activity.component';
import { CompletedActivityDetailComponent } from './completed-activity-detail.component';
import { CompletedActivityUpdateComponent } from './completed-activity-update.component';
import { CompletedActivityDeletePopupComponent } from './completed-activity-delete-dialog.component';
import { ICompletedActivity } from 'app/shared/model/KarmaApp/completed-activity.model';

@Injectable({ providedIn: 'root' })
export class CompletedActivityResolve implements Resolve<ICompletedActivity> {
  constructor(private service: CompletedActivityService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<CompletedActivity> {
    const id = route.params['id'] ? route.params['id'] : null;
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<CompletedActivity>) => response.ok),
        map((completedActivity: HttpResponse<CompletedActivity>) => completedActivity.body)
      );
    }
    return of(new CompletedActivity());
  }
}

export const completedActivityRoute: Routes = [
  {
    path: 'completed-activity',
    component: CompletedActivityComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: ['ROLE_USER'],
      defaultSort: 'id,asc',
      pageTitle: 'CompletedActivities'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'completed-activity/:id/view',
    component: CompletedActivityDetailComponent,
    resolve: {
      completedActivity: CompletedActivityResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CompletedActivities'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'completed-activity/new',
    component: CompletedActivityUpdateComponent,
    resolve: {
      completedActivity: CompletedActivityResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CompletedActivities'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'completed-activity/:id/edit',
    component: CompletedActivityUpdateComponent,
    resolve: {
      completedActivity: CompletedActivityResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CompletedActivities'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const completedActivityPopupRoute: Routes = [
  {
    path: 'completed-activity/:id/delete',
    component: CompletedActivityDeletePopupComponent,
    resolve: {
      completedActivity: CompletedActivityResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CompletedActivities'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
