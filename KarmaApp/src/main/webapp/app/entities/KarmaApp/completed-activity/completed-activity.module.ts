import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { KarmaAppSharedModule } from 'app/shared';
import {
  CompletedActivityComponent,
  CompletedActivityDetailComponent,
  CompletedActivityUpdateComponent,
  CompletedActivityDeletePopupComponent,
  CompletedActivityDeleteDialogComponent,
  completedActivityRoute,
  completedActivityPopupRoute
} from './';

const ENTITY_STATES = [...completedActivityRoute, ...completedActivityPopupRoute];

@NgModule({
  imports: [KarmaAppSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    CompletedActivityComponent,
    CompletedActivityDetailComponent,
    CompletedActivityUpdateComponent,
    CompletedActivityDeleteDialogComponent,
    CompletedActivityDeletePopupComponent
  ],
  entryComponents: [
    CompletedActivityComponent,
    CompletedActivityUpdateComponent,
    CompletedActivityDeleteDialogComponent,
    CompletedActivityDeletePopupComponent
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class KarmaAppCompletedActivityModule {}
