import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { KarmaSharedModule } from 'app/shared';
import { KarmaAdminModule } from 'app/admin/admin.module';
import {
  CompletedChallengeComponent,
  CompletedChallengeDetailComponent,
  CompletedChallengeUpdateComponent,
  CompletedChallengeDeletePopupComponent,
  CompletedChallengeDeleteDialogComponent,
  completedChallengeRoute,
  completedChallengePopupRoute
} from './';

const ENTITY_STATES = [...completedChallengeRoute, ...completedChallengePopupRoute];

@NgModule({
  imports: [KarmaSharedModule, KarmaAdminModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    CompletedChallengeComponent,
    CompletedChallengeDetailComponent,
    CompletedChallengeUpdateComponent,
    CompletedChallengeDeleteDialogComponent,
    CompletedChallengeDeletePopupComponent
  ],
  entryComponents: [
    CompletedChallengeComponent,
    CompletedChallengeUpdateComponent,
    CompletedChallengeDeleteDialogComponent,
    CompletedChallengeDeletePopupComponent
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class KarmaCompletedChallengeModule {}
